package com.kp1nz.aspect;

import com.kp1nz.common.ServerResponse;
import com.kp1nz.json.ObjectMapperApi;
import com.kp1nz.redis.RedisApi;
import com.kp1nz.utils.MD5Utils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * redis缓存切面类
 *
 * @author kp1nz
 * @create 2019-01-22 20:21
 */
@Component
@Aspect
public class RedisCacheAspect {

    @Pointcut("execution(* com.kp1nz.service.impl.ProductServiceImpl.search(..))")
    public void pointCut() {
    }
    @Autowired
    RedisApi redisApi;
    @Autowired
    ObjectMapperApi objectMapperApi;

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {

        StringBuffer keyBuffer = new StringBuffer();
        Object o = null;
        try {
            //key = MD5(全类名+方法名+参数)
            //获取全类名
            String className = joinPoint.getTarget().getClass().getName();
            keyBuffer.append(className);
            //获取目标方法的方法名
            String methodName = joinPoint.getSignature().getName();
            keyBuffer.append(methodName);
            //获取方法中的参数
            Object[] args = joinPoint.getArgs();
            if (args!=null){
                for (Object args1: args) {
                    keyBuffer.append(args1);
                }
            }
            //step1：先读取缓存
            String key_noMD5 = keyBuffer.toString();
            System.out.println("=====key:"+key_noMD5);
            String key = MD5Utils.getMD5Code(keyBuffer.toString());
            String json = redisApi.get(key);
            if (json!=null &&!json.equals("")){
                System.out.println("=====读取到了缓存");
                return objectMapperApi.str2Obj(json, ServerResponse.class);
            }
            o = joinPoint.proceed();
            System.out.println("=====执行目标方法，写入数据库");
            if (o!=null){
                String jsoncache = objectMapperApi.obj2Str(o);
                redisApi.set(key,jsoncache);
                System.out.println("=====数据库的内容写入缓存");
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;

    }
}

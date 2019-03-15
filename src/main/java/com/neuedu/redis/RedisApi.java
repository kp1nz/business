package com.neuedu.redis;

import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author kp1nz
 * @create 2019-01-21 15:56
 */
@Component
public class RedisApi {
    @Autowired
    private JedisPool jedisPool;

    public  String set(String key,String value){
        String result = null;
        Jedis jedis =null;

        try {
            jedis = jedisPool.getResource();
            result = jedis.set(key, value);
        }catch (Exception e){
            jedisPool.returnBrokenResource(jedis);
        }finally {
            if (jedis!=null){
                jedisPool.returnResource(jedis);
            }
        }
        return result;
    }
    public String get(String key){
        String result = null;
        Jedis jedis =null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.get(key);
        }catch (Exception e){
            jedisPool.returnBrokenResource(jedis);
        }finally {
            if (jedis!=null){
                jedisPool.returnResource(jedis);
            }
        }
        return result;
    }
}

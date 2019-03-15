package com.neuedu.redis;

import com.neuedu.common.Const;
import com.neuedu.utils.PropertiesUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis 连接池v1.0
 * @author kp1nz
 * @create 2019-01-18 20:41
 */
public class RedisPoolTest {
    private static JedisPool pool;

    private static Integer maxTotal = Integer.parseInt(PropertiesUtils.readByKey("redis.max.total"));

    private static Integer maxIdle = Integer.parseInt(PropertiesUtils.readByKey("redis.max.idle"));

    private static Integer minIdle = Integer.parseInt(PropertiesUtils.readByKey("redis.min.idle"));

    private static String ip = (PropertiesUtils.readByKey("redis.ip"));

    private static Integer port = Integer.parseInt(PropertiesUtils.readByKey("redis.port"));


    //在获取jedis实例时，判断是否为有效的实例
    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtils.readByKey("redis.test.borrow"));
    //在返回实例时，判断是够为有效的实例
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtils.readByKey("redis.test.return"));

    private static void initPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);
        jedisPoolConfig.setBlockWhenExhausted(true);        //在连接耗尽是是否阻塞  true--等待连接，直到超时  false--抛出异常  默认true


        pool = new JedisPool(jedisPoolConfig,ip,port, Const.JEDIS_OVERTIME);
    }
    static {
        initPool();
    }

    //获取jedis实例
    public static Jedis getJedis(){
        return pool.getResource();
    }

    //放回连接
    public static void returnResource(Jedis jedis){
        pool.returnResource(jedis);
    }

    //也是往连接池中放连接
    public static void returnBrokenResource(Jedis jedis){
        pool.returnBrokenResource(jedis);
    }


    public static void main(String[] args) {
        System.out.println(PropertiesUtils.readByKey("redis.max.total"));
        Jedis jedis = getJedis();

//        Jedis jedis = new Jedis("39.105.33.241",6379,2000);
        jedis.set("kpmm_test3","kpmm99999");
        returnResource(jedis);
        pool.destroy();
        System.out.println("over");
    }
}

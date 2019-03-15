package com.neuedu.redis;

import com.neuedu.common.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author kp1nz
 * @create 2019-01-21 18:13
 */
@Component
@Configuration
//xml
public class RedisPool {
    @Autowired
    RedisProperties redisProperties;

    @Bean
    public JedisPool jedisPool(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        jedisPoolConfig.setMinIdle(redisProperties.getMinIdle());
        jedisPoolConfig.setTestOnBorrow(redisProperties.getTestBorrow());
        jedisPoolConfig.setTestOnReturn(redisProperties.getTestReturn());

        //在连接耗尽是是否阻塞  true--等待连接，直到超时  false--抛出异常  默认true
        jedisPoolConfig.setBlockWhenExhausted(true);

        return  new JedisPool(jedisPoolConfig,redisProperties.getRedisIp(),redisProperties.getRedisPort(), Const.JEDIS_OVERTIME);
    }
}

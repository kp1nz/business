package com.kp1nz.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author kp1nz
 * @create 2019-01-21 16:47
 */
@Data
@Component
@ConfigurationProperties
public class RedisProperties {

    @Value("${redis.max.total}")
    private int maxTotal;
    @Value("${redis.max.idle}")
    private int maxIdle;
    @Value("${redis.min.idle}")
    private int minIdle;
    @Value("${redis.ip}")
    private String redisIp;
    @Value("${redis.port}")
    private int redisPort;

    //在获取jedis实例时，判断是否为有效的实例
    @Value("${redis.test.borrow}")
    private Boolean testBorrow;

    //在返回实例时，判断是够为有效的实例
    @Value("${redis.test.return}")
    private Boolean testReturn;

}

package com.kp1nz.controller;

import com.kp1nz.redis.RedisApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author kp1nz
 * @create 2019-01-21 18:25
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private RedisApi redisApi;

    @RequestMapping(value = "/redis")
    public String getJedis(){
        String set = redisApi.set("test01", "ttt");
        return set;
    }

}

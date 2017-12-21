package com.example.demo.service;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aslan on 2017-12-15.
 */
@Service
public class RedisService {

    @Resource(name="redisTemplate")
    private ValueOperations<String,String> valueObj;

    public String getRedis(){
        valueObj.set("A","test");
        return valueObj.get("A");
    }
}

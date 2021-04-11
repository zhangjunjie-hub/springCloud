package com.springcloud.springcloudeurekaapiinfo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

@Component
public class RedisUtils {
    @Autowired
    private JedisPool jedisPool;






}

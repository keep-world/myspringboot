package com.test.service.impl;

import com.test.service.MyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.lang.String;

@Slf4j
@Service("myRedissonService")
public class MyRedissonServiceImpl implements MyRedisService {

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public Map<String, String> setKV(String key, String value) {
        RBucket<String> bucket = redissonClient.getBucket(key);
        boolean isBoolean = bucket.trySet(value);

        Map<String,String> map = new HashMap<String, String>();
        map.put(bucket.getName(),bucket.get());
        log.info("key={} value={} 插入Redis结果{}",bucket.getName(), bucket.get(),isBoolean);
        return  map;
    }

    @Override
    public Map<String, String> getKV(String key) {
        RBucket<String> bucket = redissonClient.getBucket(key);
        Map<String,String> map = new HashMap<String, String>();
        map.put(key,bucket.get());
        log.info("key={} value={}",key, bucket.get());
        return  map;
    }

    @Override
    public List<String> getAllKeys() {
        RKeys bucket = redissonClient.getKeys();
        List<String> list = new ArrayList<String>();
        for (String str : bucket.getKeys()) {
            list.add(str);
        }
        return list;
    }
}

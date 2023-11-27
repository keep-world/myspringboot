package com.test.service.impl;

import com.test.service.MyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service("myRedisTemplateService")
public class MyRedisTemplateServiceImpl implements MyRedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, String> setKV(String key, String value) {
        redisTemplate.opsForValue().set(key, value);

        Object result = redisTemplate.opsForValue().get(key);
        Map<String, String> map = new HashMap<String, String>();
        map.put(key, result != null ? (String) result : null);
        log.info("key={} value={} 插入Redis结果{}", key, value, result);
        return map;
    }

    @Override
    public Map<String, String> getKV(String key) {
        Object result = redisTemplate.opsForValue().get(key);
        Map<String, String> map = new HashMap<String, String>();

        map.put(key, result != null ? (String) result : null);
        log.info("key={} value={}", key, result);
        return map;
    }

    @Override
    public List<String> getAllKeys() {
        Set<String> keys = redisTemplate.keys("*");

        List<String> list = new ArrayList<String>();
        for (String str : keys) {
            list.add(str);
        }
        return list;
    }

}

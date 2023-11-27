package com.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MyTest_redisTemplate {

    Logger logger = LoggerFactory.getLogger(MyTest_redisTemplate.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private  RedisTemplate redisTemplate;

    @Test
    public void insertKV(){
        String old_key = "k";
        String old_value = "v";

        List<String> keys = new ArrayList<String>();
        for (int i = 1000; i <= 1050; i++) {
            String new_key = old_key + i;
            String new_value = old_value + i;
            keys.add(new_key);
            stringRedisTemplate.opsForValue().set(new_key,new_value);
        }
        log.info("数据插入完毕 {} 条 keylist={}",keys.size(),String.join(",",keys));
    }

    @Test
    public void getKVs(){
        String old_key = "k";
        for (int i = 100; i <= 150; i++) {
            String new_key = old_key + i;
            Object result= stringRedisTemplate.opsForValue().get(new_key);
            log.info("获取数据完毕！key={} value={}",new_key,result);
        }
    }

    @Test
    public void setAndGetKV(){
        String key = "k1";
        String value = "v2";
        stringRedisTemplate.opsForValue().set(key,value);
        Object result= stringRedisTemplate.opsForValue().get(key);

       log.info("插入数据 key={} value={} 获取数据result={}",key,value,result);
        logger.info("-------------------------");
    }


    @Test
    public void getAndSetKVs(){
        String old_key = "k";
        String old_value = "v";

        List<String> keys = new ArrayList<String>();

        for (int i = 200; i <= 250; i++) {
            String new_key = old_key + i;
            String new_value = old_value + i;
            keys.add(new_key);
            stringRedisTemplate.opsForValue().set(new_key,new_value);
        }
        log.info("数据插入完毕 {} 条 keylist={}",keys.size(),String.join(",",keys));

        log.info("------------------------------------------------");
        for (String entry_key: keys) {
            Object result  = stringRedisTemplate.opsForValue().get(entry_key);
            log.info("获取到数据 key={} result={}",entry_key, result);
        }
    }


    @Test
    public void getAllKeys() {
        Set<String> keys = redisTemplate.keys("k1");


        log.info("all keys ={}", keys);

        logger.info("-------------------------");
    }


}

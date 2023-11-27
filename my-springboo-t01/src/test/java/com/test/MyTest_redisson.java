package com.test;

import jodd.datetime.TimeUtil;
import org.junit.Test;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RBucket;
import org.redisson.api.RKeys;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.StringCodec;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest_redisson {

    @Autowired
    private RedissonClient redissonClient;


    @Test
    public void test04() {
        RKeys rKeys = redissonClient.getKeys();
//        rKeys.getKeys().forEach((key)->{
//            System.out.println(key);
//        });
        log.info("keys ={}", String.join(",", rKeys.getKeys()));
    }


    @Test
    public void test05() {
        String old_key = "k";
        String old_value = "v";

        List<String> keys = new ArrayList<String>();
        for (int i = 500; i <= 550; i++) {
            String new_key = old_key + i;
            String new_value = old_value + i;
            keys.add(new_key);
            RBucket<String> bucket = redissonClient.getBucket(new_key);
            String result = bucket.getAndSet(new_value);
            log.info("插入redis的数据 key={} value={}", new_key, result);
        }
        System.out.println("--------------------------------------------------------------------");
        Object entryResult = null;
        for (String key_entry : keys) {
            RBucket<String> bucket = redissonClient.getBucket(key_entry);
            entryResult = bucket.get();
            while (entryResult == null) {
                try {
                    log.info("获取数据失败 key={} value={} 延后1秒再次尝试", key_entry, entryResult);
                    Thread.sleep(500 * 1,TimeUtil.SECONDS_IN_DAY);
                    entryResult = bucket.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("获取数据成功 key={} value={}", key_entry, entryResult);
            entryResult = null;
        }
    }


    @Test
    public void test06() {
        String old_key = "k";
        String old_value = "v";

        List<String> keys = new ArrayList<String>();
        for (int i = 500; i <= 550; i++) {
            String new_key = old_key + i;
            keys.add(new_key);
        }

        for (String key_entry : keys) {
            RBucket<Object> bucket = redissonClient.getBucket(key_entry);
            Object entryResult = bucket.get();

            while (entryResult == null) {
                try {
                    log.info("获取数据失败 key={} value={} 延后1秒再次尝试", key_entry, entryResult);
                    entryResult = null;
                    Thread.sleep(1000 * 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.info("获取数据成功 key={} value={}", key_entry, entryResult);
        }
    }

    @Test
    public void test07() {
        String key = "k501";
        RBucket<Object> bucket = redissonClient.getBucket(key);
        Object value = bucket.get();
        log.info("获取数据 key={} value={}", key, value);
    }


    /**
     * redisson自带有布隆过滤器，
     */
    public void boolFilter() {
        RedissonClient redisson = redissonClient;

        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("nameList");
        // 初始化布隆过滤器：预计元素为100000000L,误差率为0.003,根据这两个参数会计算出底层的bit数组大小
        bloomFilter.tryInit(100000L, 0.003);


        // 将zxxk插入到布隆过滤器中
        bloomFilter.add("zxxk");
        bloomFilter.add("baidu");

        // 判断下面名称是否在布隆过滤器中
        System.out.println(bloomFilter.contains("sina"));// false
        System.out.println(bloomFilter.contains("google"));// false
        System.out.println(bloomFilter.contains("zxxk"));// true

    }

}

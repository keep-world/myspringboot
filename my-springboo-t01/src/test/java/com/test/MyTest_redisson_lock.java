package com.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
public class MyTest_redisson_lock {

    //1，分布式锁应该事先Lock的接口规范
    //2，Lock（）枷锁的关键
    //2.1，加锁的本质是在Redis中，给key键设置一个值，为避免死锁，还需要给该值一个过期时间
    //2.2，自旋  （抢锁不成功，就sleep等待一段时间后再次尝试抢锁）
    //2.3  自动续期 （后台启动一个watchdog守护线程，每隔超时时间的1/3的时间对锁的超时时间进行延长续期）
    //3，unlock()解锁 （检查是不是自己的锁，是的话，删除）

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void test01() throws Exception {
        //RLock就是红锁
        RLock rloock=  redissonClient.getLock(""); //锁的key ，也就是Redis中要保存的那个值

        rloock.tryLock(1,1, TimeUnit.SECONDS); //加锁，并设置锁过期时间为1s

        rloock.unlock();
    }



}

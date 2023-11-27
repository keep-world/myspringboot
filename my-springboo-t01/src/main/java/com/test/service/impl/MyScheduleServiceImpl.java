package com.test.service.impl;

import com.test.properties.MypropertiesOne;
import com.test.service.MyScheduleService;
import io.micrometer.core.instrument.util.TimeUtils;
import jodd.datetime.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class MyScheduleServiceImpl implements MyScheduleService {

    @Autowired
    private MypropertiesOne mypropertiesOne;

//    @Async
    @Scheduled(cron = "* * * * * ?")    //cron 表达式  second(秒) minute(分) hour(时) day of month(日) month(月), day of week(第几周)
    public void scheduleOne() {
        String id = UUID.randomUUID().toString();
        log.info("{} 周期性任务执行!.... {}",Thread.currentThread().getName()+ "_" + id, mypropertiesOne.toString());
        try {
            Thread.sleep(3* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{} 周期性任务执行数据结束!",Thread.currentThread().getName() + "_" + id);
    }


//    @Async
    @Scheduled(cron = "* * * * * ?")    //cron 表达式  second(秒) minute(分) hour(时) day of month(日) month(月), day of week(第几周)
    public void scheduleTwo() {
        String id = UUID.randomUUID().toString();
        log.info("{} scheduleTwo周期性任务执行!.... {}",Thread.currentThread().getName()+ "_" + id);
        try {
            Thread.sleep(5* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{} scheduleTwo周期性任务执行数据结束!",Thread.currentThread().getName() + "_" + id);
    }



//    @Async
    @Scheduled(cron = "* * * * * ?")    //cron 表达式  second(秒) minute(分) hour(时) day of month(日) month(月), day of week(第几周)
    public void scheduleThree() {
        String id = UUID.randomUUID().toString();
        log.info("{} scheduleThree周期性任务执行!.... {}",Thread.currentThread().getName()+ "_" + id);
        try {
            Thread.sleep(10000* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("{} scheduleThree周期性任务执行数据结束!",Thread.currentThread().getName() + "_" + id);
    }
}

package com.test.service.impl;

import com.test.service.MyAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.Future;

@Service("mySyncServiceImpl")
@Slf4j
public class MySyncServiceImpl implements MyAsyncService {


    @Override
    public void doNoReturn() {
        try {
            // 这个方法执行需要三秒
            Thread.sleep(3000);
            log.info("方法执行结束" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Future<String> doReturn(int i) {
        try {
            // 这个方法需要调用500毫秒
            Thread.sleep(2000);
            log.info("执行中【{}】",i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 消息汇总
        return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书", i));
    }
}

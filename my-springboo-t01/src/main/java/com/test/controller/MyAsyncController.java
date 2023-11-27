package com.test.controller;

import com.test.service.MyAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@Slf4j
@RequestMapping("/myasync")
public class MyAsyncController {
    @Autowired
    @Qualifier("myAsyncServiceImpl")
    private MyAsyncService myAsyncServiceImpl;

    @Autowired
    @Qualifier("mySyncServiceImpl")
    private MyAsyncService mySyncServiceImpl;

    @GetMapping(value = "/do_no_return_sync")
    public String doNoReturn_sync(){
        long start = System.currentTimeMillis();
        mySyncServiceImpl.doNoReturn();
        return String.format("任务执行成功,耗时{%s}", System.currentTimeMillis() - start);
    }

    @GetMapping(value = "/do_no_return_async")
    public String doNoReturn_Async(){
        long start = System.currentTimeMillis();
        myAsyncServiceImpl.doNoReturn();
        return String.format("任务执行成功,耗时{%s}", System.currentTimeMillis() - start);
    }


    @GetMapping("/do_return_sync")
    public Map<String, Object> doReturn_Sync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Map<String, Object> map = new HashMap<>();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = mySyncServiceImpl.doReturn(i);
            futures.add(future);
        }
        List<String> response = new ArrayList<>();
        for (Future future : futures) {
            String string = (String) future.get();
            response.add(string);
        }
        map.put("data", response);
        map.put("消耗时间", String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
        return map;
    }

    @GetMapping("/do_return_async")
    public Map<String, Object> doReturn_Async() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Map<String, Object> map = new HashMap<>();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = myAsyncServiceImpl.doReturn(i);
            futures.add(future);
        }
        List<String> response = new ArrayList<>();
        for (Future future : futures) {
            String string = (String) future.get();
            response.add(string);
        }
        map.put("data", response);
        map.put("消耗时间", String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
        return map;
    }


}

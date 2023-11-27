package com.test.controller;


import com.test.service.MyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/myredisson")
@Slf4j
public class MyRedissonController {

    @Autowired
    @Qualifier("myRedissonService")
    private MyRedisService myRedisService;

    @GetMapping("/setKV/{k}/{v}")
    public Map<String, String> setKV( @PathVariable("k") String key,
            @PathVariable("v") String value) {
        return myRedisService.setKV(key, value);
    }

    @GetMapping("/getKV/{k}")
    public Map<String, String> getKV( @PathVariable("k") String key) {
        return myRedisService.getKV(key);
    }

    @GetMapping("/getAllKeys")
    public List<String> getAllKeys() {
        return myRedisService.getAllKeys();
    }
}

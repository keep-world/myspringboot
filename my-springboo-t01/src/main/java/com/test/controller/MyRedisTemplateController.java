package com.test.controller;

import com.test.service.MyRedisService;
import com.test.service.impl.MyRedisTemplateServiceImpl;
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
@RequestMapping("/myredistemplate")
@Slf4j
public class MyRedisTemplateController {

    @Autowired
    @Qualifier("myRedisTemplateService")
    private MyRedisService myRedisService;

    @GetMapping("/getKV/{k}")
    public Map<String, String> getKV(@PathVariable("k") String key) {
        return  myRedisService.getKV(key);
    }

    @GetMapping("/setKV/{k}/{v}")
    public Map<String, String> setKV(@PathVariable("k") String key,
                                             @PathVariable("v") String value) {
        return  myRedisService.setKV(key,value);
    }

    @GetMapping("/getAllKeys")
    public List<String> getAllKeys() {
        return myRedisService.getAllKeys();
    }

}

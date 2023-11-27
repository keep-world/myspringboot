package com.test.controller;

import com.test.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/mystartertest")
public class MyStarterHelloController {

    @Autowired
    public HelloService helloService;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String myName ){
        String result = helloService.sayHellAtguigu(myName);
        log.info("result={}",result);
        return result;
    }

}

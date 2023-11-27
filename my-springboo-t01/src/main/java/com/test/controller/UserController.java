package com.test.controller;

import com.test.properties.MypropertiesOne;
import com.test.pojo.Employee;
import com.test.pojo.User;
import com.test.service.EmployeeService;
import com.test.service.UserService;
import com.test.service.impl.MyRedisTemplateServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    public ServletContext servletContext;

    @Autowired
    public UserService userService;

    @Autowired
    public MypropertiesOne mypropertiesOne;

    @GetMapping(path = "/test")
    public String test(){
        log.info("test01当前方法执行完毕!");
        return "test01方法执行完毕！";
    }

    @GetMapping("/showMyProperties")
    public String showMyProperties(){
        log.info(mypropertiesOne.toString());
        return mypropertiesOne.toString();
    }

    @GetMapping(path = "/selectUserJoin")
    public List<User>  selectUserJoin(){
        List<User> list=  userService.selectJoin();
        log.info("查询完毕共有{}条数据", list.size());
        return  list;
    }



}

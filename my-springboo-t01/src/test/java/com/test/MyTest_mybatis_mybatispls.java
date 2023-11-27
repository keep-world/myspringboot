package com.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.test.controller.UserController;
import com.test.mappers.TempDemoOneMapper;
import com.test.pojo.TempDemoOne;
import com.test.service.TempDemoOneService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest_mybatis_mybatispls {

   @Autowired
    public UserController userController;

    @Autowired
    public TempDemoOneMapper tempDemoOneMapper;

    @Autowired
    public TempDemoOneService tempDemoOneService;

    @Test
    public void test01() {
        String str = userController.test();
        log.info(">>>>" + str);

        List<String> list = Arrays.asList("a1", "a2", "a3");
        String b = String.join(",", list);
        log.info(b);
    }

    @Test
    public void test02() {
        log.info("运行开始!");
        TempDemoOne tdo1 = new TempDemoOne();
        tdo1.setName("小明");
        tdo1.setAge(111.11);
        tempDemoOneMapper.insert(tdo1);
        log.info("运行结束!");
    }


    @Test
    public void test03() {
        log.info("运行开始!");
        TempDemoOne tdo1 = new TempDemoOne();
        tdo1.setName("小明2");
        tdo1.setAge(222.22);
        tempDemoOneService.save(tdo1);
        log.info("运行结束!");
    }

    @Test
    public void test04() {
        log.info("运行开始!");
        List<TempDemoOne> list = new ArrayList<TempDemoOne>();
        for (int i = 1; i < 20; i++) {
            TempDemoOne tdo = new TempDemoOne();
            tdo.setName("小红" + i);
            tdo.setAge(Math.random());
            list.add(tdo);
        }

        tempDemoOneService.saveBatch(list, 3);
        log.info("运行结束!");
    }

    @Test
    public void test05() {
        log.info("运行开始!");
        tempDemoOneMapper.deleteById("f0ddb3e2c0c7139f4cec3065f33f1cd2");
//        tempDemoOneService.removeById("54ed2889e4495b260e8b310d0acc4a4a");
        log.info("运行结束!");
    }

    @Test
    public void test06() {
        log.info("运行开始!");

        TempDemoOne tdo1 = tempDemoOneService.getById("e54a65f546b155724158ec42c8dc61c8");

        TempDemoOne tdo2 = tempDemoOneService.getById("e54a65f546b155724158ec42c8dc61c8");

        log.info("原始age ={}", tdo1.getAge());
        tdo1.setAge(555.00);

        tdo2.setAge(6666.44);
        log.info("tdo1 执行结果{}", tempDemoOneService.updateById(tdo1));
        log.info("tdo2 执行结果{}", tempDemoOneService.updateById(tdo2));

        log.info("运行结束!");
    }


    @Test
    public void test07() {
        log.info("运行开始!");

        QueryWrapper<TempDemoOne> queryWrapper = new QueryWrapper<TempDemoOne>();

//        queryWrapper.eq("temp_name","小红");
        queryWrapper.like("temp_name", "小红");

        List<TempDemoOne> resultList = tempDemoOneMapper.selectList(queryWrapper);

        for (TempDemoOne tdo : resultList) {
            log.info(">>>>" + tdo);
        }


        log.info("运行结束!");
    }


    @Test
    public void test08() {
        log.info("运行开始!");

        QueryWrapper<TempDemoOne> queryWrapper = new QueryWrapper<TempDemoOne>();
        queryWrapper.eq("temp_name", "小红3");
//        queryWrapper.like("temp_name","小红3");


        LambdaQueryWrapper<TempDemoOne> lambdaQueryWrapper = new LambdaQueryWrapper<TempDemoOne>();
        lambdaQueryWrapper.eq(TempDemoOne::getName, "小红4");
//        lambdaQueryWrapper.like(TempDemoOne::getAge,"小红4");
        List<TempDemoOne> list1 = tempDemoOneMapper.selectList(queryWrapper);
        List<TempDemoOne> list2 = tempDemoOneMapper.selectList(lambdaQueryWrapper);
        log.info(list1.toString());
        log.info(list2.toString());
        log.info("运行结束!");
    }

    @Test
    public void test09() {
        log.info("运行开始!");

        UpdateWrapper<TempDemoOne> updateWrapper = new UpdateWrapper<TempDemoOne>();

//        updateWrapper.eq("temp_name", "小红")
//                .set("temp_age", 123.123);
        updateWrapper.like("temp_name", "小红")
                .set("temp_age", 123.123);


        LambdaUpdateWrapper<TempDemoOne> lambdaUpdateWrapper = new LambdaUpdateWrapper<TempDemoOne>();
//        lambdaUpdateWrapper.eq(TempDemoOne::getName, "小明")
//                .set(TempDemoOne::getAge, 321.321);
        lambdaUpdateWrapper.like(TempDemoOne::getName, "小明")
                .set(TempDemoOne::getAge, 321.321);

//        TempDemoOne tempDemoOne = new TempDemoOne();
//        tempDemoOne.setName("狗剩子");
//        tempDemoOne.setAge(000.00);

        int row1 = tempDemoOneMapper.update(null, updateWrapper);
        int row2 = tempDemoOneMapper.update(null, lambdaUpdateWrapper);

        log.info("row1={} row2={}", row1, row2);
        log.info("运行结束!");
    }
}

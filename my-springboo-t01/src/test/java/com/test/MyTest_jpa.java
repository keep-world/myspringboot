package com.test;

import com.test.pojo.jpa.dao.TestOneJpa;
import com.test.repository.TestOneJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class MyTest_jpa {


    @Autowired
    private TestOneJpaRepository testOneJpaRepository;

    @Test
    public void save(){
        TestOneJpa testOneJpa= new TestOneJpa();
        testOneJpa.setName("小王2");
        testOneJpa.setAge(101);
        testOneJpa.setMoney(20.00);
        testOneJpa.setRemark("随便的描述");
        TestOneJpa new_testOneJpa= testOneJpaRepository.save(testOneJpa);
        log.info("数据插入成功! new_testOneJpa={}", new_testOneJpa.toString());
    }
}

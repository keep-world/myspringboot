package com.test.init;

import com.test.properties.MypropertiesOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//自定义springboot初始化ioc信息后的初始化类
public class MySpringBootStartInit implements ApplicationRunner {

    @Autowired
    private MypropertiesOne mypropertiesOne;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("》》》》》》》【MySpringBootStartInit.ApplicationRunner】 初始化相应的参数! {}", mypropertiesOne.toString());

    }
}

package com.test.init;

import com.test.properties.MypropertiesOne;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MySpringBootStartTwoInit implements CommandLineRunner {


    @Autowired
    private MypropertiesOne mypropertiesOne;

    @Override
    public void run(String... args) throws Exception {
        log.info("》》》》》》》【MySpringBootStartTwoInit.CommandLineRunner】 初始化相应的参数! {}", mypropertiesOne.toString());

    }
}

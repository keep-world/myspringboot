package com;


import org.apache.ibatis.type.Alias;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableWebMvc  //spring-boot-starter-web中已经集成了该标签以及下属配置，无需再引入
@MapperScan("com.test.mappers")
@EnableSwagger2
@EnableAspectJAutoProxy  //开启aop功能
@SpringBootApplication(scanBasePackages = "com.test")
public class Main {

    public static void main(String[] args){

        SpringApplication.run(Main.class , args);
    }

}

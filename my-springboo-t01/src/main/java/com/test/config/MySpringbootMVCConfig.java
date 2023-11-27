package com.test.config;

import com.test.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc   //该标签使得WebMvcConfigurationSupport被加入ioc容器，
                  // web相关的自动配置将失效
                  //后面的springmvc使用需要像springmvc里面一样，需要自己将
                  // filter,sevlet,listener,inceptor等组件添加到ioc中才能使用
public class MySpringbootMVCConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MyInterceptor())
        .addPathPatterns("/user/**").excludePathPatterns("/user/selectAll");
    }


}

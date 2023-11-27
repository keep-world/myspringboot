package com.test.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor{

    public static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(">>>SpringMVC.Interceptor 前置拦截运行开始.....");
        if(handler != null){
            log.info(">>>SpringMVC.Interceptor 准备执行的controller类为{} {}", handler.toString());
        }
        log.info(">>>SpringMVC.Interceptor 前置拦截运行完毕.....");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info(">>>SpringMVC.Interceptor 结果返回拦截运行开始.....");
        if(handler != null){
            log.info(">>>SpringMVC.Interceptor 执行完成的类信息{}", handler.toString());
        }
        log.info(">>>SpringMVC.Interceptor 结果返回拦截运行完毕.....");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info(">>>SpringMVC.Interceptor 后置拦截运行开始.....");
        if(handler != null){
            log.info(">>>SpringMVC.Interceptor 将要执行的类信息{} {}", handler.toString());
        }

        if(ex != null){
            log.info(">>>SpringMVC.Interceptor 返回异常信息 {}", ex.toString());
        }

        log.info(">>>SpringMVC.Interceptor 后置拦截运行.....");
    }
}

package com.test.mymvc.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Slf4j
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        log.info("》》》自定义Listener 【MyListener】初始化执行完毕!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("》》》自定义Listener 【MyListener】销毁执行完毕!");

    }
}

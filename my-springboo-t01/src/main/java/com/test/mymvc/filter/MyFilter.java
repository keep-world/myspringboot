package com.test.mymvc.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        log.info("》》》 自定义过滤器【MyFilter】执行开始.....");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("》》》 自定义过滤器【MyFilter】执行结束!");
    }

    @Override
    public void destroy() {

    }
}

package com.test.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.test.properties.MyDruidProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableConfigurationProperties(MyDruidProperties.class)
public class MyDruidConfig {

    @Autowired
    private  MyDruidProperties myDruidProperties;

    @Bean
    public DataSource druid(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDbType(myDruidProperties.getMyDbType());
        dataSource.setName(myDruidProperties.getMyDbName());
        dataSource.setUrl(myDruidProperties.getJdbcUrl());
        dataSource.setUsername(myDruidProperties.getJdbcUsername());
        dataSource.setPassword(myDruidProperties.getJdbcPassword());
        dataSource.setDriverClassName(myDruidProperties.getJdbcDriverClassName());
        dataSource.setInitialSize(myDruidProperties.getInitialSize());
        dataSource.setMinIdle(myDruidProperties.getMinIdle());
        dataSource.setMaxActive(myDruidProperties.getMaxActive());
        dataSource.setMaxWait(myDruidProperties.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(myDruidProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(myDruidProperties.getMinEvictableIdleTimeMillis());
        dataSource.setValidationQuery(myDruidProperties.getValidationQuery());
        dataSource.setTestWhileIdle(myDruidProperties.getTestWhileIdle());
        dataSource.setTestOnBorrow(myDruidProperties.getTestOnBorrow());
        dataSource.setTestOnReturn(myDruidProperties.getTestOnReturn());
        dataSource.setPoolPreparedStatements(myDruidProperties.getPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(myDruidProperties.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setConnectProperties(myDruidProperties.getConnectionProperties());
        dataSource.setUseGlobalDataSourceStat(myDruidProperties.getUseGlobalDataSourceStat());
        try {
            dataSource.setFilters(myDruidProperties.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        initParams.put("allow","");//默认就是允许所有访问
        initParams.put("deny","192.168.15.21");
        bean.setInitParameters(initParams);

        return bean;
    }

    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
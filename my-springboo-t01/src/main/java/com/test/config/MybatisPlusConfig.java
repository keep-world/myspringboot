package com.test.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor  mybatisPlusIntercepter = new MybatisPlusInterceptor();

        mybatisPlusIntercepter.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); //乐观锁相关
        mybatisPlusIntercepter.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); //分页查询相关
        mybatisPlusIntercepter.addInnerInterceptor(new BlockAttackInnerInterceptor()); //全表删除操作检查相关
        return mybatisPlusIntercepter;
    }
}

package com.test.config;


import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

@Slf4j
@Configuration
public class RedisConfiguration {

    @Value("${redisson.redis-service-mode}")
    private String  redisServiceMode;

    @Bean
    public RedissonClient redissonClient() throws IOException {
        ResourceLoader loader = new DefaultResourceLoader();
        Config config = null;
        switch (redisServiceMode){
            case "single":{
                log.info("redisson【single】初始化.....");
                Resource resource = loader.getResource("application-redisson-single.yml");
                config = Config.fromYAML(resource.getInputStream());
                config.useSingleServer();
                break;
            }
            case "cluster":{
                log.info("redisson【cluster】初始化.....");
                Resource resource = loader.getResource("application-redisson-cluster.yml");
                config = Config.fromYAML(resource.getInputStream());
                config.useClusterServers();
                break;
            }
            default:{
                log.error("redis的模式必须为[single/cluster]，非法的模式redis-service-mode={}", redisServiceMode);
            }
        }
        return Redisson.create(config);
    }

}

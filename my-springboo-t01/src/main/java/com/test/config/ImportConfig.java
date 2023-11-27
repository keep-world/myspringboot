package com.test.config;

import com.test.properties.MypropertiesOne;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@Import(MypropertiesOne.class)
@EnableConfigurationProperties(MypropertiesOne.class)
public class ImportConfig {
}

package com.dotk.autoconfigure.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(value = {
    "com.dotk.core",
})
@EnableConfigurationProperties
@Configuration
@EnableAsync
public class CoreAutoConfiguration {

}

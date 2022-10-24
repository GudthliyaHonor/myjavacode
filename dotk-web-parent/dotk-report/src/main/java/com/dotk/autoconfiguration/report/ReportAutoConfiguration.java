package com.dotk.autoconfiguration.report;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(value = {
    "com.dotk.report",
})
@EnableConfigurationProperties
@Configuration
@EnableAsync
public class ReportAutoConfiguration {

}

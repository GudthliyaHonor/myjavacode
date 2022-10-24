package com.dotk.autoconfigure.oauth;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(value = {
    "com.dotk.oauth.api",
    "com.dotk.oauth.app",
    "com.dotk.oauth.config",
    "com.dotk.oauth.domain",
    "com.dotk.oauth.infra"
})
@EnableConfigurationProperties
@Configuration
@EnableAsync
public class OauthAutoConfiguration {

}

package com.dotk.autoconfigure.oauth;

import java.lang.annotation.*;

import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OauthAutoConfiguration.class)
public @interface EnableDotkOauth {
    
}

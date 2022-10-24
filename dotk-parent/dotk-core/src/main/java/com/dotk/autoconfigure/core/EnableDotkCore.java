package com.dotk.autoconfigure.core;

import java.lang.annotation.*;

import org.springframework.context.annotation.Import;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CoreAutoConfiguration.class)
public @interface EnableDotkCore {
    
}

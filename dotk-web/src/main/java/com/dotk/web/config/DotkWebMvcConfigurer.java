package com.dotk.web.config;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class DotkWebMvcConfigurer implements WebMvcConfigurer {

//  @Value("${dotk.api.pathPrefix:/api/v1}")
//  private String prefix;

  @Autowired
  private List<HandlerInterceptor> handlerInterceptors;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    log.info("------ DotkWebMvcConfigurer addInterceptors ------");
    for(HandlerInterceptor interceptor: handlerInterceptors) {
      registry.addInterceptor(interceptor).addPathPatterns("/api/v1/**");
    }
  }

//  @Override
//  public void configurePathMatch(PathMatchConfigurer configurer) {
////    WebMvcConfigurer.super.configurePathMatch(configurer);
//    log.info("-----DotkWebMvcConfigurer configurePathMatch----" + prefix);
//    configurer.addPathPrefix(prefix, c -> c.isAnnotationPresent(ApiRestController.class));
//  }
}

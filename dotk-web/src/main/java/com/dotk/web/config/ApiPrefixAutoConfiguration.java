package com.dotk.web.config;

import com.dotk.core.annotation.ApiRestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class ApiPrefixAutoConfiguration implements WebMvcConfigurer {

  @Value("${api.path_prefix:/api/v1}")
  private String prefix;

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
//    WebMvcConfigurer.super.configurePathMatch(configurer);
    log.info("-----ApiPrefixAutoConfiguration configurePathMatch----" + prefix);
    configurer.addPathPrefix(prefix, c -> c.isAnnotationPresent(ApiRestController.class));
  }
}

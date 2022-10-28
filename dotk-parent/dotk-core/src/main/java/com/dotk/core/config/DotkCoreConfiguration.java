package com.dotk.core.config;

import com.dotk.core.annotation.ApiRestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class DotkCoreConfiguration implements WebMvcConfigurer {

  @Value("${dotk.api.pathPrefix:/api/v1}")
  private String prefix;

  @Override
  public void configurePathMatch(PathMatchConfigurer configurer) {
//    WebMvcConfigurer.super.configurePathMatch(configurer);
    log.info("-----DotkCoreConfiguration configurePathMatch----" + prefix);
    configurer.addPathPrefix(prefix, c -> c.isAnnotationPresent(ApiRestController.class));
  }

//  @Override
//  public void addFormatters(FormatterRegistry registry) {
//    registry.addConverter(new StringToDtoConverter());
//  }
}

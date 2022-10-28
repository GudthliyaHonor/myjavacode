package com.dotk.platform.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableWebSecurity(debug = true)
@Slf4j
public class DotkPlatformConfig {

  @Bean
  public FilterRegistrationBean filter0() {
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.setFilter(new PlatformLoginFilter());
    bean.addUrlPatterns("/api/v1/**");
    bean.setOrder(1);
    return bean;
  }
}

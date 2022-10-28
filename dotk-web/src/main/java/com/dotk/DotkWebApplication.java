package com.dotk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.dotk"})
@MapperScan("com.dotk.**.infra.mapper")
@ServletComponentScan
public class DotkWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(DotkWebApplication.class, args);
  }

  @Bean
  public ServletWebServerFactory webServerFactory() {
    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
    factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector ->
        {
          connector.setProperty("relaxedQueryChars", "[]{}");
        }
    );
    return factory;
  }
}

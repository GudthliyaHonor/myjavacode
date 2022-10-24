package com.dotk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dotk"})
@MapperScan("com.dotk.**.infra.mapper")
public class DotkWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(DotkWebApplication.class, args);
  }


}

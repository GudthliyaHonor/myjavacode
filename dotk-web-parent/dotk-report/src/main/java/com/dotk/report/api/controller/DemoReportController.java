package com.dotk.report.api.controller;

import com.dotk.core.annotation.Anonymous;
import com.dotk.core.annotation.ApiRestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@ApiRestController
@ControllerAdvice
public class DemoReportController {

  @Anonymous
  @GetMapping("/report/my/demo")
  public String myReport() {
    return "Hello dotk report";
  }

}

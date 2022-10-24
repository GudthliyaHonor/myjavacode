package com.dotk.platform.api.controller;


import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiRestController("/account")
public class Account extends BaseController {

  @GetMapping("/{id}")
  public AjaxResult get() {
    return AjaxResult.success();
  }

}

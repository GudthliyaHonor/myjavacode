package com.dotk.oauth.api.controller;

import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.core.domain.model.LoginBody;
import com.dotk.core.utils.StringUtils;
import com.dotk.oauth.domain.service.PasswordLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiRestController("/user")
public class PasswordLoginController extends BaseController {

  @Autowired
  private PasswordLoginService passwordLoginService;

 @PostMapping("/login")
 public AjaxResult passwordLogin(@RequestBody LoginBody loginBody) {
   logger.error("------passswordlogin-----");
   AjaxResult ajax = AjaxResult.success();
   boolean isEmptyParam = StringUtils.isEmpty(loginBody.getUsername()) || StringUtils.isEmpty(loginBody.getPassword()) || StringUtils.isEmpty(loginBody.getCode());
   if (isEmptyParam) {
     return AjaxResult.error("Missing params Error");
   }
   String token = passwordLoginService.login(loginBody.getCode(), loginBody.getUsername(), loginBody.getPassword(), loginBody.getCaptcha());
   ajax.put("token", token);
   return ajax;
 }

  // @PostMapping("/login")
  // public AjaxResult passwordLogin(@RequestBody MultiValueMap<String, String> values) {
  //   logger.error("------passswordlogin-----");
  //   String username = values.get("username").get(0);
  //   String password = values.get("password").get(0);
  //   String code = values.get("code").get(0);
  //   String captcha = values.get("captcha") != null && !values.get("captcha").isEmpty() ? values.get("captcha").get(0) : null;
  //   AjaxResult ajax = AjaxResult.success();
  //   boolean isEmptyParam = StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(code);
  //   if (isEmptyParam) {
  //     return AjaxResult.error("Missing params Error");
  //   }
  //   String token = passwordLoginService.login(code, username, password, captcha);
  //   ajax.put("token", token);
  //   return ajax;
  // }

  @PostMapping("/test")
  public String test(@RequestBody MultiValueMap<String, String> values) {
    logger.error("K=V Map - {}" , values);
    return "OK";
  }
  
  @PostMapping("/logout")
  public String logout() {
    return "OK";
  }

  @GetMapping("/status")
  public String status() {
    return "OK";
  }
}

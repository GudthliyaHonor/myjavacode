package com.dotk.oauth.api.controller;

import com.dotk.core.annotation.Anonymous;
import com.dotk.core.annotation.ApiRestController;
import com.dotk.core.controller.BaseController;
import com.dotk.core.domain.AjaxResult;
import com.dotk.core.domain.AppContextHolder;
import com.dotk.core.domain.model.AppContext;
import com.dotk.core.domain.model.LoginBody;
import com.dotk.core.utils.StringUtils;
import com.dotk.oauth.domain.service.PasswordLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@ApiRestController("/user")
@Slf4j
public class DotkUserController extends BaseController {

  @Autowired
  private PasswordLoginService passwordLoginService;

  @Anonymous
  @PostMapping("/login")
  public AjaxResult passwordLogin(@RequestBody LoginBody loginBody) {
    log.error("------passswordlogin-----");
    AjaxResult ajax = AjaxResult.success();
    boolean isEmptyParam = StringUtils.isEmpty(loginBody.getUsername()) || StringUtils.isEmpty(loginBody.getPassword()) || StringUtils.isEmpty(loginBody.getCode());
    if (isEmptyParam) {
      return AjaxResult.error("Missing params Error");
    }
    String token = passwordLoginService.login(loginBody.getCode(), loginBody.getUsername(), loginBody.getPassword(), loginBody.getCaptcha());
    AppContext info = AppContextHolder.getContext();
    ajax.putData("token", token);
    ajax.putData("account", info.getTenant());
    ajax.putData("user", info.getUser());
    return ajax;
  }

  @PostMapping("/logout")
  public AjaxResult logout() {
    passwordLoginService.logout();
    return AjaxResult.success();
  }

  @GetMapping("/status")
  public AjaxResult status() {
    AppContext info = passwordLoginService.status();
    AjaxResult result = AjaxResult.success();
    result.putData("user", info.getUser());
    result.putData("account", info.getTenant());
    // TODO: more output data here
    return AjaxResult.success();
  }
}

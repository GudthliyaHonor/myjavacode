package com.dotk.oauth.config;

//import com.dotk.core.domain.entity.SysAccount;

import com.alibaba.fastjson2.JSONObject;
import com.dotk.core.domain.AppContextHolder;
import com.dotk.core.domain.entity.SysUser;
import com.dotk.core.domain.model.AppContext;
import com.dotk.core.exception.ServiceException;
import com.dotk.core.utils.StringUtils;
import com.dotk.oauth.app.service.PasswordService;
import com.dotk.oauth.domain.entity.User;
import com.dotk.oauth.domain.service.UserService;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class TokenUserDetailsService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordService passwordService;

  private int aid = 0;

  public void setAid(int aid) {
    this.aid = aid;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("----TokenUserDetailsService loadUserByUsername ----");

    long aid = 0; // demo
    AppContext appContext = AppContextHolder.getContext();
    if (appContext != null) {
      aid = appContext.getAid();
    }
    log.info("Account ID: " + aid);

    User user = userService.selectUserByUsernameWithAid(username, aid);
    if (StringUtils.isNull(user)) {
      throw new ServiceException("User " + username + " not found or removed");
    }

    passwordService.validate(user);
    SysUser sysUser = JSONObject.parseObject(JSONObject.toJSONString(user), SysUser.class);
    return createLoginUser(sysUser);
  }

  public UserDetails createLoginUser(SysUser user) {
    return new AppContext(user, new HashSet<String>());
  }
}

package com.dotk.oauth.config;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.dotk.core.exception.ServiceException;
import com.dotk.core.utils.StringUtils;
import com.dotk.oauth.app.service.PasswordService;
import com.dotk.oauth.domain.entity.User;
import com.dotk.oauth.domain.model.LoginUser;
import com.dotk.oauth.domain.service.UserService;


@Component
public class TokenUserDetailsService implements UserDetailsService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TokenUserDetailsService.class);

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordService passwordService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    LOGGER.error("----TokenUserDetailsService loadUserByUsername ----");
    User user = userService.selectUserByUsername(username);
    if (StringUtils.isNull(user)) {
      throw new ServiceException("User " + username + " not found or removed");
    }

    passwordService.validate(user);
    return createLoginUser(user);
  }

  public UserDetails createLoginUser(User user)
  {
      return new LoginUser(user.getId(), 0L, user, new HashSet<String>());
  }
}

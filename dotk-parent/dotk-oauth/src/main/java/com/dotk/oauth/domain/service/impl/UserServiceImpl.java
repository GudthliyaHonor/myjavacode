package com.dotk.oauth.domain.service.impl;

import com.dotk.core.cache.CacheService;
import com.dotk.oauth.constant.Cache;
import com.dotk.oauth.domain.entity.User;
import com.dotk.oauth.domain.service.UserService;
import com.dotk.oauth.domain.vo.UserVO;
import com.dotk.oauth.infra.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private CacheService cacheService;

  @Override
  public User selectUserByUsername(String username) {
    username = username.toLowerCase();
    return userMapper.selectUserByUsername(username);
  }

  @Override
  public User selectUserByUsernameWithAid(String username, long aid) {
    username = username.toLowerCase();

    String cacheKey = getCacheKey(aid, username);
    User user = cacheService.getCacheObject(cacheKey);
    if (null == user) {
      UserVO userVO = new UserVO();
      userVO.setUsername(username);
      userVO.setAid(aid);
      user = userMapper.selectUserByUsernameWithAid(userVO);
      if (null != user) {
        cacheService.setCacheObject(cacheKey, user);
      }
    }
    return user;
  }

  protected String getCacheKey(Long aid, String username) {
    return Cache.ITEM_KEY + aid + ":" + username;
  }
}

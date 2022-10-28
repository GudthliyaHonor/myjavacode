package com.dotk.oauth.app.service;

import com.dotk.core.constant.CacheConstants;
import com.dotk.core.exception.user.UserPasswordNotMatchException;
import com.dotk.core.exception.user.UserPasswordRetryLimitExceedException;
import com.dotk.core.cache.impl.RedisService;
import com.dotk.core.utils.SecurityUtils;
import com.dotk.oauth.config.AuthenticationContextHolder;
import com.dotk.oauth.config.SimpleAuthenticationToken;
import com.dotk.oauth.domain.entity.User;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

  @Autowired
  private RedisService redisCache;

  @Value(value = "${user.password.maxRetryCount}")
  private int maxRetryCount;

  @Value(value = "${user.password.lockTime}")
  private int lockTime;

  /**
   * 登录账户密码错误次数缓存键名
   *
   * @param username 用户名
   * @return 缓存键key
   */
  private String getCacheKey(String username, String companyCode) {
    return CacheConstants.PWD_ERR_CNT_KEY + username;
  }

  public void validate(User user) {
    SimpleAuthenticationToken usernamePasswordAuthenticationToken = (SimpleAuthenticationToken) AuthenticationContextHolder.getContext();
    String username = usernamePasswordAuthenticationToken.getName();
    String password = usernamePasswordAuthenticationToken.getCredentials().toString();
    String companyCode = usernamePasswordAuthenticationToken.getCompanyCode().toString();

    Integer retryCount = redisCache.getCacheObject(getCacheKey(username, companyCode));

    if (retryCount == null) {
      retryCount = 0;
    }

    if (retryCount >= Integer.valueOf(maxRetryCount).intValue()) {
      // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
      //         MessageUtils.message("user.password.retry.limit.exceed", maxRetryCount, lockTime)));
      throw new UserPasswordRetryLimitExceedException(maxRetryCount, lockTime);
    }

    if (!matches(user, password)) {
      retryCount = retryCount + 1;
      // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL,
      //         MessageUtils.message("user.password.retry.limit.count", retryCount)));
      redisCache.setCacheObject(getCacheKey(username, companyCode), retryCount, lockTime, TimeUnit.MINUTES);
      throw new UserPasswordNotMatchException();
    } else {
      clearLoginRecordCache(username, companyCode);
    }
  }

  public boolean matches(User user, String rawPassword) {
    return SecurityUtils.matchesPassword(rawPassword, user.getPassword());
  }

  public void clearLoginRecordCache(String loginName, String companyCode) {
    if (redisCache.hasKey(getCacheKey(loginName, companyCode))) {
      redisCache.deleteObject(getCacheKey(loginName, companyCode));
    }
  }
}

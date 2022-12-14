package com.dotk.oauth.app.service;

import com.dotk.core.constant.CacheConstants;
import com.dotk.core.constant.Constants;
import com.dotk.core.domain.model.AppContext;
import com.dotk.core.cache.impl.RedisService;
import com.dotk.core.utils.ServletUtils;
import com.dotk.core.utils.StringUtils;
import com.dotk.core.utils.ip.AddressUtils;
import com.dotk.core.utils.ip.IpUtils;
import com.dotk.core.utils.uuid.IdUtils;
import eu.bitwalker.useragentutils.UserAgent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TokenService.class);

  // 令牌自定义标识
  @Value("${token.header}")
  private String header;

  // 令牌秘钥
  @Value("${token.secret}")
  private String secret;

  // 令牌有效期（默认30分钟）
  @Value("${token.expireTime}")
  private int expireTime;

  protected static final long MILLIS_SECOND = 1000;

  protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

  private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;

  @Autowired
  private RedisService redisCache;

  /**
   * 获取用户身份信息
   *
   * @return 用户信息
   */
  public AppContext getLoginUser(HttpServletRequest request) {
    // 获取请求携带的令牌
    String token = getToken(request);
    if (StringUtils.isNotEmpty(token)) {
      try {
        Claims claims = parseToken(token);
        // 解析对应的权限以及用户信息
        String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
        String userKey = getTokenKey(uuid);
        AppContext user = redisCache.getCacheObject(userKey);
        return user;
      } catch (Exception e) {
        LOGGER.error(e.getMessage());
      }
    }
    return null;
  }

  /**
   * 设置用户身份信息
   */
  public void setLoginUser(AppContext appContext) {
    if (StringUtils.isNotNull(appContext) && StringUtils.isNotEmpty(appContext.getToken())) {
      refreshToken(appContext);
    }
  }

  /**
   * 删除用户身份信息
   */
  public void delLoginUser(String token) {
    if (StringUtils.isNotEmpty(token)) {
      String userKey = getTokenKey(token);
      redisCache.deleteObject(userKey);
    }
  }

  /**
   * 创建令牌
   *
   * @param appContext 用户信息
   * @return 令牌
   */
  public String createToken(AppContext appContext) {
    String token = IdUtils.fastUUID();
    appContext.setToken(token);
    setUserAgent(appContext);
    refreshToken(appContext);

    Map<String, Object> claims = new HashMap<>();
    claims.put(Constants.LOGIN_USER_KEY, token);
    claims.put(Constants.LOGIN_COMPANY_KEY, appContext.getAid());
    return createToken(claims);
  }

  /**
   * 验证令牌有效期，相差不足20分钟，自动刷新缓存
   *
   * @param appContext
   * @return 令牌
   */
  public void verifyToken(AppContext appContext) {
    long expireTime = appContext.getExpireTime();
    long currentTime = System.currentTimeMillis();
    if (expireTime - currentTime <= MILLIS_MINUTE_TEN) {
      refreshToken(appContext);
    }
  }

  /**
   * 刷新令牌有效期
   *
   * @param appContext 登录信息
   */
  public void refreshToken(AppContext appContext) {
    appContext.setLoginTime(System.currentTimeMillis());
    appContext.setExpireTime(appContext.getLoginTime() + expireTime * MILLIS_MINUTE);
    // 根据uuid将loginUser缓存
    String userKey = getTokenKey(appContext.getToken());
    redisCache.setCacheObject(userKey, appContext, expireTime, TimeUnit.HOURS);
  }

  /**
   * 设置用户代理信息
   *
   * @param appContext 登录信息
   */
  public void setUserAgent(AppContext appContext) {
    UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
    String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
    appContext.setIpaddr(ip);
    appContext.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
    appContext.setBrowser(userAgent.getBrowser().getName());
    appContext.setOs(userAgent.getOperatingSystem().getName());
  }

  /**
   * 从数据声明生成令牌
   *
   * @param claims 数据声明
   * @return 令牌
   */
  private String createToken(Map<String, Object> claims) {
//    System.out.println("++++++++++++++++secret: " + secret);
    String token = Jwts.builder()
        .setClaims(claims)
        .signWith(SignatureAlgorithm.HS512, secret).compact();
    return token;
//        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
//        String token = Jwts.builder()
//                .setClaims(claims)
//                .signWith(secretKey, SignatureAlgorithm.HS512)
//                .compact();
//        return token;
  }

  /**
   * 从令牌中获取数据声明
   *
   * @param token 令牌
   * @return 数据声明
   */
  private Claims parseToken(String token) {
//        JwtParserBuilder builder = Jwts.parserBuilder();
//        SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
//        return builder.setSigningKey(secretKey)
//            .build()
//            .parseClaimsJws(token)
//            .getBody();
    return Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .getBody();
  }

  /**
   * 从令牌中获取用户名
   *
   * @param token 令牌
   * @return 用户名
   */
  public String getUsernameFromToken(String token) {
    Claims claims = parseToken(token);
    return claims.getSubject();
  }

  /**
   * 获取请求token
   *
   * @param request
   * @return token
   */
  private String getToken(HttpServletRequest request) {
    String token = request.getHeader(header);
    if (StringUtils.isNotEmpty(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
      token = token.replace(Constants.TOKEN_PREFIX, "");
    }
    return token;
  }

  private String getTokenKey(String uuid) {
    return CacheConstants.LOGIN_TOKEN_KEY + uuid;
  }
}

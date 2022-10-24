package com.dotk.oauth.config;

import com.dotk.oauth.app.service.TokenService;
import com.dotk.oauth.domain.model.LoginUser;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

  @Resource
  private RedisTemplate<String, Object> redisTemplate;

  @Autowired
  private TokenService tokenService;

  @Override
  protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain)
      throws ServletException, IOException {

    LoginUser loginUser = tokenService.getLoginUser(request);

//    Assert.notNull(loginUser, "登录已过期请重新登录");

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (loginUser != null && authentication == null) {
      UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
      userToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

      SecurityContextHolder.getContext().setAuthentication(userToken);
    }

    filterChain.doFilter(request, response);
  }
}

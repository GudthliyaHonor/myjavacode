package com.dotk.platform.configure;

import com.alibaba.fastjson2.JSONObject;
import com.dotk.core.domain.AppContextHolder;
import com.dotk.core.domain.RequestWrapper;
import com.dotk.core.domain.model.AppContext;
import com.dotk.core.domain.model.Tenant;
import com.dotk.platform.domain.service.AccountService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Slf4j
public class DotkPlatformLoginInterceptor implements HandlerInterceptor {

  @Autowired
  private AccountService accountService;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    log.info("----- DotkPlatformLoginInterceptor preHandle -----");
    String requestUri = request.getRequestURI();
    String requestMethod = request.getMethod();

    if (request instanceof RequestWrapper) {
      handleLogin(request, requestUri, requestMethod);
      handleNonLogin(request, requestUri);
    }
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  private void handleLogin(HttpServletRequest request, String requestUri, String requestMethod) {
    if ("/api/v1/user/login".equalsIgnoreCase(requestUri) && "POST".equalsIgnoreCase(requestMethod)) {
      RequestWrapper wrapper = (RequestWrapper) request;
      String body = wrapper.getPostBodyAsString();

      if (null != body && !"".equals(body)) {
        JSONObject jsonObject = JSONObject.parseObject(body);
        if (null != jsonObject) {
          String companyCode = (String) jsonObject.get("code");
          log.info("Company code: " + companyCode);
          if (null != companyCode) {
            Tenant tenant = accountService.selectAccountByCode(companyCode);
            if (null != tenant) {
              AppContext appContext = new AppContext();
              appContext.setTenant(tenant);
              AppContextHolder.setContext(appContext);
            }
          }
        }
      }
    }
  }

  private void handleNonLogin(HttpServletRequest request, String requestUri) {
    if (!"/api/v1/user/login".equalsIgnoreCase(requestUri)) {

    }
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    log.info("----- DotkPlatformLoginInterceptor postHandle -----");
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    log.info("----- DotkPlatformLoginInterceptor afterCompletion -----");
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}

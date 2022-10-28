package com.dotk.platform.configure;

import com.dotk.core.domain.RequestWrapper;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@WebFilter(urlPatterns = "/api/v1/*")
@Component
@Slf4j
public class PlatformLoginFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    log.info("---- PlatformLoginFilter init ----");
    Filter.super.init(filterConfig);
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    log.info("---- PlatformLoginFilter doFilter ----");
    ServletRequest requestWrapper = null;
    if (request instanceof HttpServletRequest) {
      requestWrapper = new RequestWrapper((HttpServletRequest) request);
    }
    if (null == requestWrapper) {
      chain.doFilter(request, response);
    }
    else {
      chain.doFilter(requestWrapper, response);
    }
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}

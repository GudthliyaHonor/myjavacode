package com.dotk.oauth.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class SimpleAuthenticationToken extends UsernamePasswordAuthenticationToken {

  private Object companyCode;

  public SimpleAuthenticationToken(Object principal, Object credentials, Object companyCode) {
    super(principal, credentials);
    this.companyCode = companyCode;
  }

  public Object getCompanyCode() {
    return companyCode;
  }

}

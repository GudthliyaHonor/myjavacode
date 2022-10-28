package com.dotk.oauth.domain.service;


import com.dotk.core.domain.model.AppContext;

public interface PasswordLoginService {

  /**
   * Login action.
   *
   * @param companyCode Company code
   * @param username
   * @param password
   * @param captcha
   * @return Token string
   */
  String login(String companyCode, String username, String password, String captcha);

  /**
   * Logout action.
   */
  void logout();

  /**
   * Get login info.
   *
   * @return
   */
  AppContext status();
}

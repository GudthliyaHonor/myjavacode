package com.dotk.oauth.domain.service;


public interface PasswordLoginService {
    /**
     * Login action.
     * @param companyCode Company code
     * @param username
     * @param password
     * @param captcha
     * @return Token string
     */
    String login(String companyCode, String username, String password, String captcha);

}

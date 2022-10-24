package com.dotk.oauth.domain.service;

import com.dotk.oauth.domain.entity.User;

public interface UserService {

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    User selectUserByUsername(String username);
}

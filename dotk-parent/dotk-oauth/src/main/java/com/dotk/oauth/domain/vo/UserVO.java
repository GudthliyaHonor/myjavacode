package com.dotk.oauth.domain.vo;

import com.dotk.oauth.domain.entity.User;

public class UserVO {

    private String token;

    private User user;

    private Object account;

    private Object employee;

    private Object permission;

    public UserVO(String token, User user, Object account, Object employee, Object permissions) {
        this.token = token;
        this.user = user;
        this.account = account;
        this.employee = employee;
        this.permission = permissions;
    }
    
}

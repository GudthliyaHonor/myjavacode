package com.dotk.core.domain.model;

import lombok.Data;

/**
 * 用户登录对象
 * 
 * @author ruoyi
 */
@Data
public class LoginBody
{

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 公司编码
     */
    private String code;

    /**
     * 验证码
     */
    private String captcha;

    /**
     * 唯一标识
     */
    private String uuid;

}

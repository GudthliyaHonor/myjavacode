package com.dotk.oauth.domain.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import com.dotk.core.exception.ServiceException;
import com.dotk.core.exception.user.UserPasswordNotMatchException;
import com.dotk.oauth.app.service.TokenService;
import com.dotk.oauth.config.AuthenticationContextHolder;
import com.dotk.oauth.config.SimpleAuthenticationToken;
import com.dotk.oauth.domain.model.LoginUser;
import com.dotk.oauth.domain.service.PasswordLoginService;


@Service
public class PasswordLoginServiceImpl implements PasswordLoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    // @Autowired
    // private UserMapper userMapper;

    @Autowired
    private TokenService tokenService;

    public String login(String companyCode, String username, String password, String captcha) {
        // TODO: 检查图形验证码是否开启

        Authentication authentication = null;
        try {
            SimpleAuthenticationToken authenticationToken = new SimpleAuthenticationToken(username, password, companyCode);
            AuthenticationContextHolder.setContext(authenticationToken);
    
            // 该方法会去调用TokenUserDetailsService.loadUserByUsername
            authentication = authenticationManager.authenticate(authenticationToken);
        }
        catch (Exception e)
        {
            if (e instanceof BadCredentialsException)
            {
                // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
                throw new UserPasswordNotMatchException();
            }
            else
            {
                // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage()));
                throw new ServiceException(e.getMessage());
            }
        }
        finally
        {
            AuthenticationContextHolder.clearContext();
        }
        

        // AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        recordLoginInfo(loginUser.getUserId());
        // 生成token
        return tokenService.createToken(loginUser);
    }

    
    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId)
    {
    }
}

package com.dotk.oauth.config;

import com.dotk.oauth.config.properties.PermitAllUrlProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
// 仅在Servlet环境下生效
@ConditionalOnWebApplication(type = Type.SERVLET)
// 确保安全属性配置信息被加载并以bean的形式被注册到容器
@EnableConfigurationProperties(SecurityProperties.class)
// 仅在特定类存在于classpath上生效
//@ConditionalOnClass({AbstractSecurityWebApplicationInitializer.class,
//SessionCreationPolicy.class})
// 指定该配置类在 SecurityAutoConfiguration 配置类应用之后应用
//@AutoConfigureAfter(SecurityAutoConfiguration.class)
//@AutoConfigureBefore(UserDetailsServiceAutoConfiguration.class)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SimpleTokenFilter {

  private static final Logger LOGGER = LoggerFactory.getLogger(SimpleTokenFilter.class);

  private static final String[] PERMITTED_PATHS = new String[]{
      "/sample/**",
      "/api/v1/user/login"
  };

  @Autowired
  private AccessDeniedHandler accessDeniedHandler;

  @Autowired
  private TokenAuthenticationFilter tokenAuthenticationFilter;

  @Autowired
  private TokenUserDetailsService tokenUserDetailsService;

  @Autowired
  private PermitAllUrlProperties permitAllUrlProperties;

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    LOGGER.error("---------oauth securityFilterChain---------");
    ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
    permitAllUrlProperties.getUrls().forEach(url -> {
      LOGGER.info("anonymous url: " + url);
      registry.antMatchers(url).permitAll();
    });

    // @formatter:off
    return http.cors()
        .and()
        // CSRF禁用，因为不使用session
        .csrf().disable()
        // 登录行为自行实现
        .formLogin().disable()
        .httpBasic().disable()

        // 过滤请求
        .authorizeRequests()
        // 忽略验证
        .antMatchers(PERMITTED_PATHS).permitAll()
        // 其它请求必须验证
        .anyRequest().authenticated()
        //
        .and().logout().disable()

        // 基于token，不需要session
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        .and().userDetailsService(tokenUserDetailsService)

        .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
        .and().addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)

        .build();
    // @formatter:on

    // TODO: 短信登录

    // TODO：第三方登录

  }

  /**
   * 强散列哈希加密实现
   */
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}

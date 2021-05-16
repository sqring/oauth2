package com.sqring.auth.sso.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoRestTemplateFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

/**
 * @author www.zhouwenfang.com
 * @version 1.0.0
 * @ClassName SsoSecurityConfig.java
 * @Description 单点登录
 * @createTime 2021年05月16日
 */
@EnableOAuth2Sso // 开启单点登录功能
@Configuration
public class SsoSecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(UserInfoRestTemplateFactory factory) {
        return factory.getUserInfoRestTemplate();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 首页所有人都可以访问
                .antMatchers("/").permitAll()
                //其他要认证后才可以访问，如 /member
                .anyRequest().authenticated()
                .and()
                .logout()
                //当前应用退出后，会交给某个处理
                // 请求认证服务器将用户进行退出
                .logoutSuccessUrl("http://localhost:7001/auth/logout")
                .and()
                .csrf().disable()
        ;

    }
}
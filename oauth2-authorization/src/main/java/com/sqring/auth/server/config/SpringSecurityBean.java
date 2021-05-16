package com.sqring.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author www.zhouwenfang.com
 * @version 1.0.0
 * @ClassName SpringSecurityBean.java
 * @Description 加密方式
 * @createTime 2021年05月14日
 */
@Configuration
public class SpringSecurityBean {

    @Bean // 加密方式
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
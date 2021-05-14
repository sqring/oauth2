package com.sqring.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author www.zhouwenfang.com
 * @version 1.0.0
 * @ClassName CustomUserDetailsService.java
 * @Description TODO
 * @createTime 2021年05月15日
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired // 在 SpringSecurityBean 添加到容器了
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("admin", passwordEncoder.encode("1234"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("product"));

    }
}
package com.sqring.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author www.zhouwenfang.com
 * @version 1.0.0
 * @ClassName AuthServerApplication.java
 * @Description 认证服务器启动类
 * @createTime 2021年05月14日
 */
@SpringBootApplication
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
    }
}
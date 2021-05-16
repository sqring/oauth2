package com.sqring.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author www.zhouwenfang.com
 * @version 1.0.0
 * @ClassName ZuulServer_7001.java
 * @Description zuul网关
 * @createTime 2021年05月16日
 */
@EnableZuulProxy //开启zuul的功能
@EnableEurekaClient
@SpringBootApplication
public class ZuulServer_7001 {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServer_7001.class, args);
    }

}
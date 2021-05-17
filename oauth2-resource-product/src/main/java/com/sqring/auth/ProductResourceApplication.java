package com.sqring.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProductResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductResourceApplication.class, args);
    }

}

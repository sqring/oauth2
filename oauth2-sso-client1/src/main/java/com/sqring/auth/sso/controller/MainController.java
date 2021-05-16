package com.sqring.auth.sso.controller;

import com.sqring.auth.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @auther: www.zhouwenfang.com
 */
@Controller
public class MainController {


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    @GetMapping("/member")
    public String member() {
//        R result = oAuth2RestTemplate.getForObject("http://localhost:8080/product/list", R.class);
        ResponseEntity<R> entity =
                oAuth2RestTemplate.getForEntity("http://localhost:7001/product/list", R.class);
        R body = entity.getBody();
        System.out.println("body: " + body);
        return "member";
    }
}
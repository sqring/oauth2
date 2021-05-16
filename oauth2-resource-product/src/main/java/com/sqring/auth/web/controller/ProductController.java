package com.sqring.auth.web.controller;

import com.sqring.auth.util.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author www.zhouwenfang.com
 * @version 1.0.0
 * @ClassName ProductController.java
 * @Description TODO
 * @createTime 2021年05月15日
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/list")
    //@PreAuthorize("hasAuthority('product:list')")
    public R list() {
        List<String> list = new ArrayList<>();
        list.add("眼镜");
        list.add("格子衬衣");
        list.add("双肩包");
        return R.ok(list);
    }
}
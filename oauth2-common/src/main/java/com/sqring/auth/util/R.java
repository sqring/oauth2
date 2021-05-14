package com.sqring.auth.util;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

/**
 * @author www.zhouwenfang.com
 * @version 1.0.0
 * @ClassName R.java
 * @Description 自定义返回页面json数据格式
 * @createTime 2021年05月14日
 */
@Data
public class R implements Serializable {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String message;

    // 响应中的数据
    private Object data;

    public R() {
    }
    public R(Object data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }
    public R(String message, Object data) {
        this.code = 200;
        this.message = message;
        this.data = data;
    }

    public R(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static R ok() {
        return new R(null);
    }
    public static R ok(String message) {
        return new R(message, null);
    }
    public static R ok(Object data) {
        return new R(data);
    }
    public static R ok(String message, Object data) {
        return new R(message, data);
    }

    public static R build(Integer code, String message) {
        return new R(code, message, null);
    }

    public static R build(Integer code, String message, Object data) {
        return new R(code, message, data);
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }


    /**
     * JSON字符串转成对象
     * @param json
     * @return
     */
    public static R format(String json) {
        try {
            return JSON.parseObject(json, R.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
package com.lazyboy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 简单web初始化
 */

@RestController//@RestController = @Controller+@ResponseBody 以JSON形式返回
public class HelloController {

    @GetMapping("/hello")
    public LazyResponse hello() {
        return new LazyResponse(100, "hello,lazy boy!");
    }


}

class LazyResponse {
    private int code;
    private String msg;

    LazyResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
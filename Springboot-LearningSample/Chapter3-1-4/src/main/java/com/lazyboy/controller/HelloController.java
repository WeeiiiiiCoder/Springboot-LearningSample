package com.lazyboy.controller;

import com.lazyboy.errorHandler.RegistryException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 简单web初始化
 */

@Controller//@RestController = @Controller+@ResponseBody 以JSON形式返回
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/registry")
    public String registry() {
        throw new RegistryException("注册失败");
    }
}

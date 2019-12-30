package com.lazy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        request.setAttribute("host", "LazyBoy-Learning-SpringBoot");
        return "index";
    }
}

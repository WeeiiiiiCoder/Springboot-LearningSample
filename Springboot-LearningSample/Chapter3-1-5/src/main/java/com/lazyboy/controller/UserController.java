package com.lazyboy.controller;

import com.lazyboy.primary.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/")
    public User getUser(@RequestBody User user) {
        return user;
    }
}

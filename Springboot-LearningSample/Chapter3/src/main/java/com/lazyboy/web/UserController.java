package com.lazyboy.web;

import com.lazyboy.primary.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")//处理"/users/"的GET请求
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @GetMapping("/{id}")//处理"/users/{id}"的GET请求,url中参数可通过@PathVariable注解绑定
    public User getUserById(@PathVariable("id") long id) {
        return users.get(id);
    }

    @PostMapping("/")//处理"/users/"的POST请求
    public String createUser(@RequestBody User user) {
        //请求参数可以通过@RequestBody绑定到User类,也可以通过@RequestParam单个绑定
        users.put(user.getId(), user);
        return "success";
    }

    @PutMapping("/{id}")//处理"/users/{id}"的PUT请求-Update操作
    public String updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User old = users.get(id);
        old.setName(user.getName());
        old.setAge(user.getAge());
        users.put(id, old);
        return "success";
    }

    @DeleteMapping("/{id}")//处理"/users/{id}"的DELETE请求-DELETE操作
    public String deleteUser(@PathVariable("id") long id) {
        users.remove(id);
        return "success";
    }
}

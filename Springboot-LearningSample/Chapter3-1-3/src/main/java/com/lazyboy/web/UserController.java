package com.lazyboy.web;

import com.lazyboy.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping("/")//处理"/users/"的GET请求
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @ApiOperation(value = "获取指定Id用户详情", notes = "获取指定Id用户详情")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "Long")
    @GetMapping("/{id}")//处理"/users/{id}"的GET请求,url中参数可通过@PathVariable注解绑定
    public User getUserById(@PathVariable("id") long id) {
        return users.get(id);
    }

    @ApiOperation(value = "创建新用户", notes = "创建新用户")
    @ApiImplicitParam(name = "user", value = "用户Bean", required = true, dataType = "User")
    @PostMapping("/")//处理"/users/"的POST请求
    public String createUser(@RequestBody User user) {
        //请求参数可以通过@RequestBody绑定到User类,也可以通过@RequestParam单个绑定
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "更新用户信息", notes = "更新指定Id用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户Bean", required = true, dataType = "User")
    })
    @PutMapping("/{id}")//处理"/users/{id}"的PUT请求-Update操作
    public String updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User old = users.get(id);
        old.setName(user.getName());
        old.setAge(user.getAge());
        users.put(id, old);
        return "success";
    }

    @ApiOperation(value = "删除用户信息", notes = "删除指定Id用户")
    @ApiImplicitParam(name = "id", value = "用户Id", required = true, dataType = "Long")
    @DeleteMapping("/{id}")//处理"/users/{id}"的DELETE请求-DELETE操作
    public String deleteUser(@PathVariable("id") long id) {
        users.remove(id);
        return "success";
    }
}

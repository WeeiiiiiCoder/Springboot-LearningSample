package com.lazyboy.service;

/**
 * @Author LAZYBOY
 * @Date 18:23 2019/12/30
 */
public interface UserService {

    void create(String name, Integer age);

    void deleteByName(String name);

    Integer getAllUsers();

    void deleteAllUsers();
}
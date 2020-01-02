package com.lazyboy.domain;

import javax.persistence.*;

/**
 * @Author LAZYBOY
 * @Date 10:58 2019/12/31
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}

package com.lazyboy.domain;

import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface UserMapper {

    @Insert("insert into user(name,age) values(#{name},#{age})")
    void insertUser(@Param("name") String name, @Param("age") int age);

    @Select("select * from user where name = #{name}")
    User selectUserByName(@Param("name") String name);

    @Results({
            @Result(property = "username", column = "name")
    })
    @Select("select * from user where name = #{username}")
    User selectByUser(User user);

    @Update("update user set name = #{username} where name = #{name}")
    void updateUser(@Param("username") String username, @Param("name") String name);

    @Delete("delete from user where id = #{id,jdbcType=INTEGER}")
    void deleteUser(Map map);

    @Select("select count(1) from user")
    int amount();
}

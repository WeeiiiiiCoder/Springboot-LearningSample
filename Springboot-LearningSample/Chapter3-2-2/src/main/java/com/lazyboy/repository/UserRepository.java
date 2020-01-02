package com.lazyboy.repository;

import com.lazyboy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * SpringData-JPA UserRepository
 *
 * @Author LAZYBOY
 * @Date 16:35 2019/12/31
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findByNameAndAge(String name, int age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}

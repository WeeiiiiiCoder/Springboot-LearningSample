package com.lazyboy;

import com.lazyboy.domain.User;
import com.lazyboy.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        userMapper.insertUser("LAZY BOY 1", 22);
        userMapper.insertUser("LAZY BOY 2", 23);
        userMapper.insertUser("LAZY BOY 3", 24);
        userMapper.insertUser("LAZY BOY 4", 25);
        Assert.assertEquals(4, userMapper.amount());
        userMapper.updateUser("LAZY BOY 1-1", "LAZY BOY 1");
        User user = userMapper.selectUserByName("LAZY BOY 1-1");
        Assert.assertEquals(22, user.getAge().intValue());
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 3);
        userMapper.deleteUser(map);
        Assert.assertEquals(3, userMapper.amount());
    }
}

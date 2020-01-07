package com.lazyboy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void strRedisTest() {
        stringRedisTemplate.opsForValue().set("lazyboy", "zw");
        Assert.assertEquals("zw",stringRedisTemplate.opsForValue().get("lazyboy"));
    }
}

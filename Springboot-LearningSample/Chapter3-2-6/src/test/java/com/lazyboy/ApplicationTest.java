package com.lazyboy;

import com.lazyboy.domain.User;
import com.lazyboy.domain.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void test() {
        userRepository.insert(new User(1L, "mongo1", 18));
        userRepository.insert(new User(2L, "mongo2", 20));
        userRepository.insert(new User(3L, "mongo3", 24));
        Assert.assertEquals("mongo1", userRepository.findByUsername("mongo1").getUsername());
        Assert.assertEquals(3, userRepository.count());
        userRepository.delete(1L);
        Assert.assertEquals(2, userRepository.count());
        userRepository.delete(userRepository.findByUsername("mongo2"));
        Assert.assertEquals(1, userRepository.count());
    }
}

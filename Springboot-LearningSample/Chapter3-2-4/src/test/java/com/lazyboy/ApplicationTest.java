package com.lazyboy;

import com.lazyboy.primary.PrimaryUserRepository;
import com.lazyboy.primary.User;
import com.lazyboy.secondary.SecondaryUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTest {
    @Autowired
    private PrimaryUserRepository primaryUserRepository;
    @Autowired
    private SecondaryUserRepository secondaryUserRepository;


    @Test
    public void appTest() {
        primaryUserRepository.save(new User("pri-1", 18));
        primaryUserRepository.save(new User("pri-2", 18));
        primaryUserRepository.save(new User("pri-3", 18));

        assertEquals(3, primaryUserRepository.count());
        secondaryUserRepository.save(new com.lazyboy.secondary.User("pri-1", 18));
        secondaryUserRepository.save(new com.lazyboy.secondary.User("pri-2", 18));
        secondaryUserRepository.save(new com.lazyboy.secondary.User("pri-3", 18));
        secondaryUserRepository.save(new com.lazyboy.secondary.User("pri-4", 18));
        assertEquals(4, secondaryUserRepository.count());
    }
}

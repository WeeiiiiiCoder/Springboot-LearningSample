package com.lazyboy;

import com.lazyboy.domain.User;
import com.lazyboy.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ApplicationTest {


    @Autowired
    private UserRepository userRepository;

    /**
     * ctrl +/- 展开/折叠代码
     */
    @Test
    public void jpaTest() {
        userRepository.save(new User("lazyboy-1", 24));
        userRepository.save(new User("lazyboy-2", 25));
        userRepository.save(new User("lazyboy-3", 26));

        assertEquals(3, userRepository.findAll().size());
        assertEquals(24, userRepository.findByName("lazyboy-1").getAge().longValue());

        assertEquals(24, userRepository.findUser("lazyboy-1").getAge().longValue());
        assertEquals("lazyboy-2", userRepository.findByNameAndAge("lazyboy-2", 25).getName());

        userRepository.delete(userRepository.findByName("lazyboy-1"));
        assertEquals(2, userRepository.findAll().size());
    }
}

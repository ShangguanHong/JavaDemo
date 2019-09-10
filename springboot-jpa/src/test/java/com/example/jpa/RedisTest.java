package com.example.jpa;

import com.example.jpa.domain.User;
import com.example.jpa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author sgh
 * @date 2019/9/9 12:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private UserService userService;

    @Test
    public void test1() {
        User user = new User();
        user.setId(2L);
        userService.update(user);
//        userService.findById(2L);
    }
}

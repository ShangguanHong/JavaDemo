package com.example.redis;

import com.example.redis.domain.User;
import com.example.redis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author sgh
 * @date 2019/9/10 21:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private UserService userService;

    @Test
    public void test1() {
        User user = userService.findById(1);
        System.out.println(user);
    }

    @Test
    public void test2() {
        User user = userService.findById(2);
        System.out.println(user);
        user.setUsername("sgh");
        userService.update(user);
        user = userService.findById(2);
        System.out.println(user);
    }

    @Test
    public void test3() {
        User user = userService.findById(1);
        System.out.println(user);
        userService.deleteById(1);
    }

}

package com.example.redis;

import com.example.redis.domain.User;
import com.example.redis.service.UserService;
import com.example.redis.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.impl.orbutil.HexOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sgh
 * @date 2019/9/10 21:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;

    @Test
    public void test1() {
        User user = userService.findById(1);
        System.out.println(user);
        redisUtil.set("user", user.toString());
        redisUtil.hset("hash", "test", user);
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

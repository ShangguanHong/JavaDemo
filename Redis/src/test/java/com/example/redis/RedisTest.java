package com.example.redis;

import com.example.redis.domain.User;
import com.example.redis.service.UserService;
import com.example.redis.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
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
    private RedisUtil redisUtil;

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() {
        User user;
        int id = 1;
        String key = String.valueOf(id);
        if (redisTemplate.hasKey(key)) {
            System.out.println("从redis缓存中查询用户");
            user = (User) redisTemplate.opsForValue().get(key);
        } else {
            System.out.println("从数据库中查询用户");
            user = new User();
            user.setId(id);
            user.setUsername("username:" + id);
            redisTemplate.opsForValue().set(key, user);
        }
        System.out.println(user);
    }

    /**
     * redis缓存查找
     */
    @Test
    public void test1() {
        User user = userService.findById(1);
        System.out.println(user);
        User user1 = userService.findById(1);
        System.out.println(user1);
    }

    /**
     * redis缓存更新
     */
    @Test
    public void test2() {
        User user = userService.findById(2);
        System.out.println(user);
        user.setUsername("sgh");
        userService.update(user);
        user = userService.findById(2);
        System.out.println(user);
    }

    /**
     * redis缓存删除
     */
    @Test
    public void test3() {
        User user = userService.findById(1);
        System.out.println(user);
        userService.deleteById(1);
    }

}

package com.example.redis.service.impl;

import com.example.redis.domain.User;
import com.example.redis.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author sgh
 * @date 2019/9/10 20:49
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    @Override
    @Cacheable(key = "#p0")
    public User findById(Integer id) {
        System.out.println("从数据库中查询用户");
        User user = new User();
        user.setId(id);
        user.setUsername("username:" + id.toString());
        return user;
    }

    @Override
    @CacheEvict(allEntries = true)
    public void add(User user) {
        System.out.println("增加了用户");
    }

    @Override
    @CachePut(key = "#user.getId()")
    public User update(User user) {
        System.out.println("增加了用户");
        return user;
    }

    @Override
    @CacheEvict(key = "#p0")
    public void deleteById(Integer id) {
        System.out.println("删除了用户");
    }
}

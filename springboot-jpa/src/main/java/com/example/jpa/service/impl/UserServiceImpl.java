package com.example.jpa.service.impl;

import com.example.jpa.domain.User;
import com.example.jpa.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author sgh
 * @date 2019/9/9 12:25
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserServiceImpl implements UserService {

    /**
     * find user by id
     *
     * @param id id
     * @return User
     */
    @Override
    @Cacheable(keyGenerator = "keyGenerator")
    public User findById(Long id) {
        System.out.println("从数据库中取出用户数据");
        User user = new User();
        user.setId(id);
        return user;
    }

    /**
     * update User message
     *
     * @param user user
     * @return User
     */
    @Override

    public User update(User user) {
        return null;
    }

    /**
     * delete user
     *
     * @param user user
     */
    @Override
    @CacheEvict(allEntries = true)
    public void delete(User user) {
        System.out.println("删除用户成功");
    }
}

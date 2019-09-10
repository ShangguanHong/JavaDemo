package com.example.redis.service;

import com.example.redis.domain.User;

/**
 * @author sgh
 * @date 2019/9/10 20:49
 */
public interface UserService {

    User findById(Integer id);

    void add(User user);

    User update(User user);

    void deleteById(Integer id);
}

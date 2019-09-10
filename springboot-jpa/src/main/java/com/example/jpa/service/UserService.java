package com.example.jpa.service;

import com.example.jpa.domain.User;

/**
 * @author sgh
 * @date 2019/9/9 12:24
 */
public interface UserService {

    /**
     * find user by id
     *
     * @param id id
     * @return User
     */
    User findById(Long id);

    /**
     * update User message
     *
     * @param user user
     * @return User
     */
    User update(User user);

    /**
     * delete user
     *
     * @param user user
     */
    void delete(User user);
}

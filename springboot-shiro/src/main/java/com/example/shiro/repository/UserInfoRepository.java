package com.example.shiro.repository;

import com.example.shiro.domain.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author sgh
 * @date 2019/8/18 下午1:32
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {

    /**
     * 通过username查找用户信息
     *
     * @param username username
     * @return UserInfo
     */
    public UserInfo findByUsername(String username);
}

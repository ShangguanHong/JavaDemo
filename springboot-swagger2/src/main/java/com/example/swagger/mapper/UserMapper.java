package com.example.swagger.mapper;

import com.example.swagger.domain.User;

/**
 * @author sgh
 * @date 2019/7/16 20:55
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
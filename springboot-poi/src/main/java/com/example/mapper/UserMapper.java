package com.example.mapper;
import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sgh
 * @date 2019/7/14 15:12
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll();
}
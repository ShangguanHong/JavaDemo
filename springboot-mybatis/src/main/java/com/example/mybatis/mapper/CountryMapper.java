package com.example.mybatis.mapper;

import com.example.mybatis.model.Country;

/**
 * @author sgh
 * @date 2019/8/16 下午10:58
 */
public interface CountryMapper {
    int deleteByPrimaryKey(String code);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}

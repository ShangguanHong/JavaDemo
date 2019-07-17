package com.example.demo.mapper;

import com.example.demo.model.Country;

/**
 * CountryMapper class
 *
 * @author sgh
 * @date 2019/5/30 20:30
 */

public interface CountryMapper {

    /**
     * 通过code删除城市
     *
     * @param code
     * @return 删除数量
     */
    int deleteByCode(String code);

    /**
     * 插入一条城市信息
     *
     * @param record
     * @return 成功插入数量
     */
    int insert(Country record);

    /**
     * 插入一条城市信息(selective)
     *
     * @param record
     * @return 成功插入数量
     */
    int insertSelective(Country record);

    /**
     * 通过code查询城市信息
     *
     * @param code
     * @return 查询到的城市
     */
    Country selectByCode(String code);


    /**
     * 更新code更新城市信息(selective)
     *
     * @param record
     * @return 更新成功数量
     */
    int updateByCodeSelective(Country record);

    /**
     * 通过code更新城市信息
     *
     * @param record
     * @return 更新成功数量
     */
    int updateByCode(Country record);
}
package com.example.mybatismultipledatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatismultipledatasource.entity.User;
import com.example.mybatismultipledatasource.mapper.test1.User1Mapper;
import com.example.mybatismultipledatasource.service.User1Service;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sgh
 * @date 2019/8/30 12:34
 */
@Service
public class User1ServiceImpl extends ServiceImpl<User1Mapper, User> implements User1Service {

    @Override
    @DS("slave")
    public List<User> getList() {
        return baseMapper.selectList(null);
    }
}

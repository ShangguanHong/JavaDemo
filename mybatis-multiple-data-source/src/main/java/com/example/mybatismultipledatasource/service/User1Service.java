package com.example.mybatismultipledatasource.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatismultipledatasource.entity.User;

import java.util.List;

/**
 * @author sgh
 * @date 2019/8/30 12:33
 */
public interface User1Service extends IService<User> {

    List<User> getList();

}

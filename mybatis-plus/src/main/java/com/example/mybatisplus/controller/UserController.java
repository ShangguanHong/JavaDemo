package com.example.mybatisplus.controller;


import com.example.mybatisplus.service.component.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author sgh
 * @since 2019-08-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private Test test;

    @GetMapping(value = "/{id}")
    public String test(@PathVariable(value = "id") Integer id) {
        test.sleep();
        return id.toString();
    }

    @GetMapping(value = "user/{id}")
    public String test2(@PathVariable(value = "id") Integer id) {
        return id.toString();
    }
}

package com.example.shirosinglereaml.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sgh
 * @date 2019/8/20 下午11:16
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping("/list")
    @RequiresPermissions("user:view")
    public String showUser() {
        return "/userList";
    }
}

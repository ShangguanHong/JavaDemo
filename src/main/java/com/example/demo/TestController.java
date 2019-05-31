package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sgh
 * @Date 2019/5/30 20:30
 * @Description: No Description
 */

@RestController // 这里的@RestController = @ResponseBody + @Controller，可以使每一个方法返回的都是数据而不是页面
// @Controller表示该类内的所有方法默认返回的是页面路径，加了@ResponseBody后返回的是JSON等格式的数据。

public class TestController {

    @Value("${name}")
    private String name;
    @Value("${websites}")
    private String websites;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String Test() {
        return "大家好，我的名字是:" + name + "，我的个人博客网站是:" + websites;
    }

    @Autowired // 自动注入
    private User user;
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public User Test1() {
        return user;
    }
}

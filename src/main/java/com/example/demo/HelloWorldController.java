package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
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

public class HelloWorldController {
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String HelloWorld() {
        return "Hello World!";
    }
}

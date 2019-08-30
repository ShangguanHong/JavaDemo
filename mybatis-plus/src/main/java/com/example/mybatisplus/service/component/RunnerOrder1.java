package com.example.mybatisplus.service.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author sgh
 * @date 2019/8/29 21:10
 */
@Component
public class RunnerOrder1 implements CommandLineRunner {

    @Resource
    private Test test;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().getName());
//        test.sleep();
    }
}

package com.example.mybatisplus.service.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author sgh
 * @date 2019/8/29 22:03
 */
@Component
public class RunnerOrder2 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.getClass().getName());
    }
}

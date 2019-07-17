package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DemoApplication class
 *
 * @author  sgh
 * @date 2019/5/30 20:30
 */

@SpringBootApplication // 这是启动SpringBoot启动应用程序的入口点
@MapperScan("com.example.demo.mapper") // 扫描Mapper

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

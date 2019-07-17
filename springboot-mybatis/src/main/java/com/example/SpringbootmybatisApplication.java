package com.example;

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
@MapperScan("com.example.mapper") // 扫描Mapper

public class SpringbootmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootmybatisApplication.class, args);
    }

}

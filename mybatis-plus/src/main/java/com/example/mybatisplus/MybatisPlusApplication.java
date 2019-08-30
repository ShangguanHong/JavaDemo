package com.example.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatisplus.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        System.out.println("This Application run before");
        SpringApplication.run(MybatisPlusApplication.class, args);
        System.out.println("This Application run after");
    }

}

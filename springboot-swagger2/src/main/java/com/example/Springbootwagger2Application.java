package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author sgh
 * @date 2019/7/16 20:55
 */

@SpringBootApplication
@MapperScan("com.example.mapper")
public class Springbootwagger2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootwagger2Application.class, args);
    }

}
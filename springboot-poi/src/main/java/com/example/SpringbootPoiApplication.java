package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sgh
 * @date 2019/7/14 13:48
 */

@SpringBootApplication
@MapperScan("com.example.mapper")
public class SpringbootPoiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootPoiApplication.class, args);
    }

}

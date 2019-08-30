package com.example.mybatismultipledatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mybatismultipledatasource.mapper")
public class MybatisMultipleDataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisMultipleDataSourceApplication.class, args);
    }

}

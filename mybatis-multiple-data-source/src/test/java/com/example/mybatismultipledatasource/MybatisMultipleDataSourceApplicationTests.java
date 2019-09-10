package com.example.mybatismultipledatasource;

import com.example.mybatismultipledatasource.service.User1Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisMultipleDataSourceApplicationTests {

    @Resource
    private User1Service user1Service;

    @Test
    public void contextLoads() {
        user1Service.getList().forEach(System.out::println);
    }
}

package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

/**
 * @Author sgh
 * @Date 2019/5/31 13:25
 * @Description: No Description
 */

@Data
@Component // 把普通pojo实例化到spring容器中
@ConfigurationProperties(prefix = "user") // 指明了配置文件中前缀为user封装成对象

public class User {
    private String username;
    private Integer age;
}

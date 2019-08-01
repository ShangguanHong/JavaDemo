package com.example.poi.domain;

import lombok.Data;

/**
 * @author sgh
 * @date 2019/7/14 15:12
 */
@Data
public class User {
    private Integer id;

    private String name;

    private Byte age;

    private String addr;
}
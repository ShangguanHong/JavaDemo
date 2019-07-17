package com.example.domain;

import lombok.Data;

/**
 *
 *
 * @author sgh
 * @date 2019/7/16 20:55
 */
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;
}
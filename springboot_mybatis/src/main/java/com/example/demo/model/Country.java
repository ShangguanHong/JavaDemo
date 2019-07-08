package com.example.demo.model;

import lombok.*;

/**
 * Country class
 *
 * @author sgh
 * @date 2019/5/30 20:30
 */

@Data
public class Country {
    private String code;

    private String name;

    private Integer population;
}
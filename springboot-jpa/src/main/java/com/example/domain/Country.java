package com.example.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author sgh
 * @date 2019/7/8 19:02
 */

@Entity
@Table(name = "country")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private String code;

    private String name;

    private Integer population;
}

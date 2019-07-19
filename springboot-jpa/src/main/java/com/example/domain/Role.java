package com.example.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author sgh
 * @date 2019/7/18 14:46
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_name")
    private String roleName;
}

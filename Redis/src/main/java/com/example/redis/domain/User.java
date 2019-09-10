package com.example.redis.domain;

import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sgh
 * @date 2019/9/10 21:24
 */
@Entity
@Table(name = "sys_user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 2338673090854550779L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;
}

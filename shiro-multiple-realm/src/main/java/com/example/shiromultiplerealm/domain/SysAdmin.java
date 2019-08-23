package com.example.shiromultiplerealm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sgh
 * @date 2019/8/17 下午5:28
 */
@Data
@Entity
public class SysAdmin implements Serializable {


    private static final long serialVersionUID = 2057675669846796336L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;

    private String name;

    private String password;

    private String salt;

    public String getCredentialsSalt() {
        return this.username + this.salt;
    }
}



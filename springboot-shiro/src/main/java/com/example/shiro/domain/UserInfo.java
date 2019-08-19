package com.example.shiro.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author sgh
 * @date 2019/8/17 下午5:28
 */
@Data
@Entity
@ToString(exclude = {"roleList"})
public class UserInfo implements Serializable {


    private static final long serialVersionUID = 2057675669846796336L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(unique = true)
    private String username;

    private String name;

    private String password;

    private String salt;

    private Byte state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",
            joinColumns = {@JoinColumn(name = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;

    public String getCredentialsSalt() {
        return this.username + this.salt;
    }
}


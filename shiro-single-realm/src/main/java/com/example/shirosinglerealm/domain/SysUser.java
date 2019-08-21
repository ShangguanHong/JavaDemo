package com.example.shirosinglerealm.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author sgh
 * @date 2019/8/20 下午9:25
 */
@Data
@Entity
@ToString(exclude = {"roleList"})
@EqualsAndHashCode(exclude = {"roleList"})
public class SysUser implements Serializable {


    private static final long serialVersionUID = 2057675669846796336L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @Column(unique = true)
    private String username;

    /**
     * 名称
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
     */
    private Byte state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",
            joinColumns = {@JoinColumn(name = "u_id")},
            inverseJoinColumns = {@JoinColumn(name = "r_Id")})
    private List<SysRole> roleList;

    public String getCredentialsSalt() {
        return this.username + this.salt;
    }
}
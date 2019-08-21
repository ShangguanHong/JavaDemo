package com.example.shirosinglereaml.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author sgh
 * @date 2019/8/20 下午9:28
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"userList", "permissionList"})
@ToString(exclude = {"permissionList", "userList"})
public class SysRole implements Serializable {

    private static final long serialVersionUID = -3276415633649319106L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 角色标识程序中判断使用,如"admin",这个是唯一的
     */
    private String role;

    /**
     * 角色描述,UI界面显示使用
     */
    private String description;

    /**
     * 是否可用,如果不可用将不会添加给用户
     */
    private Boolean available = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission",
            joinColumns = {@JoinColumn(name = "r_d")},
            inverseJoinColumns = {@JoinColumn(name = "p_id")})
    private List<SysPermission> permissionList;

    @JsonIgnore
    @ManyToMany(mappedBy = "roleList")
    private List<SysUser> userList;
}


package com.example.shiro.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author sgh
 * @date 2019/8/18 下午12:58
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"userInfos", "permissions"})
@ToString(exclude = {"userInfos", "permissions"})
public class SysRole implements Serializable {

    private static final long serialVersionUID = -3276415633649319106L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String role;

    private String description;

    private Boolean available = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission",
            joinColumns = {@JoinColumn(name = "roleId")},
            inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissions;

    @JsonIgnore
    @ManyToMany(mappedBy = "roleList")
    private List<UserInfo> userInfos;
}

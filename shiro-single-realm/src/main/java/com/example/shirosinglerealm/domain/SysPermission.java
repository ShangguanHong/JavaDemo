package com.example.shirosinglerealm.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author sgh
 * @date 2019/8/20 下午9:34
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"roleList"})
@ToString(exclude = {"roleList"})
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 5877361065104918109L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 资源类型，[menu|button]
     */
    @Column(columnDefinition = "enum('menu', 'button')")
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * 是否可用,如果不可用将不会添加给角色
     */
    private Boolean available = Boolean.FALSE;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissionList")
    private List<SysRole> roleList;
}

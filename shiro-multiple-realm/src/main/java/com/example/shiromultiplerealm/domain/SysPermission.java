package com.example.shiromultiplerealm.domain;

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
@EqualsAndHashCode(exclude = {"roles"})
@ToString(exclude = {"roles"})
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 5877361065104918109L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "enum('menu', 'button')")
    private String resourceType;

    private String url;

    private String permission;

    private Long parentId;

    private String parentIds;

    private Boolean available = Boolean.FALSE;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    private List<SysRole> roles;
}

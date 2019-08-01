package com.example.mapstruct.dto;

import lombok.Data;

/**
 * @author sgh
 * @date 2019/7/17 16:25
 */
@Data
public class UserRoleDto {

    private Long userId;
    private String userName;
    private String userAddr;
    private String roleName;
}

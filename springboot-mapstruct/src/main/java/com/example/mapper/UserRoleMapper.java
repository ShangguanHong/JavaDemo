package com.example.mapper;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.dto.UserRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author sgh
 * @date 2019/7/17 16:24
 */
@Mapper(componentModel = "spring")
public interface UserRoleMapper {

    // 获取该类自动生成的实现类的实例
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    // 使用单一对象
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "name", target = "userName"),
            @Mapping(source = "addr", target = "userAddr"),
            @Mapping(source = "role.name", target = "roleName"),
    })
    UserRoleDto toUserRoleDto(User user);

    // 使用两个对象
    @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "user.name", target = "userName"),
            @Mapping(source = "user.addr", target = "userAddr"),
            @Mapping(source = "role.name", target = "roleName"),
    })
    UserRoleDto toUserRoleDto(User user, Role role);
}

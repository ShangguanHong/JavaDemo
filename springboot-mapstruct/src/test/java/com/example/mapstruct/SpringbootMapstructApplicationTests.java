package com.example.mapstruct;

import com.example.mapstruct.domain.Role;
import com.example.mapstruct.domain.User;
import com.example.mapstruct.dto.UserRoleDto;
import com.example.mapstruct.mapper.UserRoleMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMapstructApplicationTests {

    @Autowired
    UserRoleMapper userRoleMapper;

    User user;

    Role role;

    @Before
    public void before() {
        // 模拟数据库数据
        role = new Role(2L, "admin", "管理员哦");
        user = new User(1L, "sgh", "China", role);
    }

    @Test
    public void contextLoads() {
        System.out.println("----------------user---------------");
        System.out.println(user);
        UserRoleDto userRoleDto = userRoleMapper.toUserRoleDto(user, role);
        System.out.println("----------------touserDto--------------");
        System.out.println(userRoleDto);
    }

}

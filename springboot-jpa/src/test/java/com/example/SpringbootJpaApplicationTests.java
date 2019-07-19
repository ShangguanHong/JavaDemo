package com.example;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private User user;

    private Role role;

    @Test
    public void contextLoads() {
//        role = roleRepository.findById(2L).get();
        Role role1 = new Role();
        role1.setRoleName("test2");
        role1.setId(3L);
        user = new User();
//        user = userRepository.findById(2L).get();
        user.setId(4L);
        user.setUserName("test1");
        user.setUserAddr("beijing");
        user.getRoles().add(role1);
        userRepository.save(user);
    }

}

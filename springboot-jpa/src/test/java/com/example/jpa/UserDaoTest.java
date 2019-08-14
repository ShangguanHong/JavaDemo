package com.example.jpa;

import com.example.jpa.domain.User;
import com.example.jpa.repository.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sgh
 * @date 2019/7/21 16:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserRepository userRepository;

    public void testUserDaoBaseOperate() {
        User user = new User();
        // 查找所有用户
        userRepository.findAll();
        // 根据id查找用户
        userRepository.findById(1L);
        // 保存/更新用户信息
        userRepository.save(user);
        // 删除用户
        userRepository.delete(user);
        // 统计用户数量
        userRepository.count();
        // 通过id查找用户是否存在
        userRepository.existsById(1L);
        // ...
    }
}

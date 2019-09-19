package com.example.jpa;

import com.example.jpa.domain.Teacher;
import com.example.jpa.domain.User;
import com.example.jpa.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootJpaApplicationTests {

    @Resource
    private UserRepository userRepository;

    @Test
    @Transactional
    public void contextLoads() {
        Teacher teacher = new Teacher();
        teacher.setId(1);
        List<User> allByTeacher = userRepository.findAllByTeacher(teacher);
        for (User user : allByTeacher) {
            System.out.println(user);
        }
    }
}

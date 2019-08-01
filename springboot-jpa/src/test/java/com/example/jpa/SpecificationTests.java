package com.example.jpa;

import com.example.jpa.domain.User;
import com.example.jpa.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sgh
 * @date 2019/7/22 16:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecificationTests {

    @Autowired
    private UserRepository userRepository;

    // 查询用户名为root的用户
    @Test
    @Transactional
    public void SpecTest1() {
        // lambda 表达式
        User user = userRepository.findOne((root, query, cb) -> {
            // 比较方式为精确查询：cb.equal
            // 比较的属性为用户名：root.get("userName")
            // 比较的类型：as(String.class)
            Predicate predicate = cb.equal(root.get("userName").as(String.class), "root");
            return predicate;
        }).get();
        System.out.println(user);
    }

    // 查询用户名为test开头的用户
    @Test
    @Transactional
    public void SpecTest2() {
        // lambda 表达式
        List<User> users = userRepository.findAll((root, query, cb) -> {
            // 比较方式为模糊查询：cb.like
            // 比较的属性为用户名：root.get("userName")
            // 比较的类型：as(String.class)
            Predicate predicate = cb.like(root.get("userName").as(String.class), "test%");
            return predicate;
        });
        for (User user : users) {
            System.out.println(user);
        }
    }

    // 查询用户名为test开头并且地址为shanghai的用户
    @Test
    @Transactional
    public void SpecTest3() {
        // lambda 表达式
        List<User> users = userRepository.findAll((root, query, cb) -> {
            // 比较方式为模糊查询：cb.like
            // 比较的属性为用户名：root.get("userName")
            // 比较的类型：as(String.class)
            List<Predicate> list = new ArrayList<>();
            list.add(cb.like(root.get("userName").as(String.class), "test%"));
            // 比较方式为精确查询：cb.equal
            // 比较的属性为地址：root.get("userAddr")
            // 比较的类型：as(String.class)
            list.add(cb.equal(root.get("userAddr").as(String.class), "shanghai"));
            Predicate[] p = new Predicate[list.size()];
            // cb.and ： 所有条件的与(或用or)
            return cb.and(list.toArray(p));
        });
        for (User user : users) {
            System.out.println(user);
        }
    }

    // 查询所有用户，并以用户ID倒序
    @Test
    @Transactional
    public void SpecTest4() {
        // 创建排序对象，需要调用构造方法实例化sort对象
        // 第一个参数：排序的顺序（Sort.Direction.ASC:正序，Sort.Direction.DESC：逆序）
        // 第二个参数：排序的属性名称
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        // lambda 表达式
        // 排序查询
        List<User> users = userRepository.findAll((root, query, cb) -> {
            // 不做条件筛选
            return null;
        }, sort);
        for (User user : users) {
            System.out.println(user);
        }
    }

    // 查询所有用户，并进行分页
    @Test
    @Transactional
    public void SpecTest5() {
        // 创建分页对象，PageRequest对象是Pageable接口的实现类
        // 调用PageRequest的构造函数实例化一个PageRequest对象
        // 第一个参数：当前查询的页数（从0开始）
        // 第二个参数：每页的数量
        Pageable pageable = new PageRequest(0, 1);
        // lambda 表达式
        // 分页查询
        Page<User> userPage = userRepository.findAll((root, query, cb) -> {
            // 不做条件筛选
            return null;
        }, pageable);
        List<User> users = userPage.getContent();
        System.out.println(users);
        System.out.println("用户总数量为：" + userPage.getTotalElements());
        System.out.println("总页数为:" + userPage.getTotalPages());
    }
}

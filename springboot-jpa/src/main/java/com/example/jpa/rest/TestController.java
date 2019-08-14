package com.example.jpa.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sgh
 * @date 2019/8/14 下午4:18
 */
@RestController
@RequestMapping("api")
public class TestController {

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String adminTest() {
        return "管理员可以访问";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/user")
    public String userTest() {
        return "普通用户可以访问";
    }
}

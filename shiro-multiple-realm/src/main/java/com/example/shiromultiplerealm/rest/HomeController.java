package com.example.shiromultiplerealm.rest;

import com.example.shiromultiplerealm.config.LoginTypeEnum;
import com.example.shiromultiplerealm.config.UserToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sgh
 * @date 2019/8/18 下午3:20
 */
@RestController
public class HomeController {


    @RequestMapping("/user/login")
    public String userLogin(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password) throws Exception {
        // 得到当前 subject
        Subject subject = SecurityUtils.getSubject();
        UserToken userToken = new UserToken(username, password, LoginTypeEnum.USER.getType());
        try {
            subject.login(userToken);
            return "用户登录成功";
        } catch (Exception e) {
            return "用户登录失败";
        }
    }

    @RequestMapping("/admin/login")
    public String adminLogin(@RequestParam(value = "username") String username,
                             @RequestParam(value = "password") String password) throws Exception {
        // 得到当前 subject
        Subject subject = SecurityUtils.getSubject();
        UserToken userToken = new UserToken(username, password, LoginTypeEnum.ADMIN.getType());
        try {
            subject.login(userToken);
            return "管理员登录成功";
        } catch (Exception e) {
            return "管理员登录失败";
        }
    }
}

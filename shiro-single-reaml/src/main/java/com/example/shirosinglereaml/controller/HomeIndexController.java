package com.example.shirosinglereaml.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sgh
 * @date 2019/8/20 下午10:45
 */
@Controller
@Slf4j
public class HomeIndexController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "username", required = false) String username,
                        @RequestParam(value = "password", required = false) String password) {
        if (username == null || password == null) {
            return "/login";
        }
        log.debug("HomeController------------------------->login()");
        // 1. 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            // 2. 执行认证登陆,没抛出异常则代表认证成功
            subject.login(token);
        } catch (UnknownAccountException uac) {
            log.debug("UnknownAccountException -- > 账号不存在：");
        } catch (IncorrectCredentialsException ice) {
            log.debug("IncorrectCredentialsException -- > 密码不正确：");
        } catch (AuthenticationException ae) {
            log.debug("AuthenticationException -- > 用户名或密码不正确：");
        } catch (Exception e) {
            log.debug("未知错误");
        }
        // 3. 判断该subject是否为已经认证过的
        if (subject.isAuthenticated()) {
            return "redirect:/index";
        } else {
            return "/login";
        }

    }

    @RequestMapping("/403")
    public String unauthorized() {
        return "/403";
    }
}

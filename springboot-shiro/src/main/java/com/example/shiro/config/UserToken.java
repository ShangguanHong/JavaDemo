package com.example.shiro.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author sgh
 * @date 2019/8/19 下午9:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserToken extends UsernamePasswordToken {
    /**
     * 登录类型
     */
    private String loginType;

    public UserToken(String username, String password, String loginType) {
        super(username, password);
        this.loginType = loginType;
    }
}


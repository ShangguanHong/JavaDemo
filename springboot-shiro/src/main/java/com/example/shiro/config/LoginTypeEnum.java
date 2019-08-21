package com.example.shiro.config;

/**
 * @author sgh
 * @date 2019/8/19 下午9:52
 */
public enum LoginTypeEnum {
    /**
     * 登录类型
     */
    USER("User"),
    ADMIN("Admin"),
    ;

    private String type;

    LoginTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

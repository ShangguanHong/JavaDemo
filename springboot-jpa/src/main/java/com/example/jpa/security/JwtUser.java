package com.example.jpa.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @author sgh
 * @date 2019/8/14 下午2:42
 */
@Data
@AllArgsConstructor
public class JwtUser implements UserDetails {
    private final Long id;
    private final String username;
    private final String password;
    /**
     * 用户的角色列表
     */
    private final Collection<? extends GrantedAuthority> authorities;
    /**
     * 用户是否激活
     */
    private final boolean enabled;
    /**
     * 最后修改密码的日期
     */
    private final Date lastPasswordResetDate;

    /**
     * 账户是否未过期
     *
     * @return true
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否未锁定
     *
     * @return true
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否未过期
     *
     * @return true
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}

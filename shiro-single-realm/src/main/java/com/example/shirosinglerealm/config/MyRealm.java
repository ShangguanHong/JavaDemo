package com.example.shirosinglerealm.config;

import com.example.shirosinglerealm.domain.SysPermission;
import com.example.shirosinglerealm.domain.SysRole;
import com.example.shirosinglerealm.domain.SysUser;
import com.example.shirosinglerealm.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author sgh
 * @date 2019/8/20 下午10:02
 */
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Resource
    private SysUserRepository sysUserRepository;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("UserRealm------------------->doGetAuthorizationInfo");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 1. 通过principalCollection.getPrimaryPrincipal()得到传入的用户信息
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        // 2. 遍历Role集合 赋予角色
        for (SysRole role : user.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            // 2. 遍历Permission集合 赋予权限
            for (SysPermission p : role.getPermissionList()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("UserRealm---------------->doGetAuthenticationInfo");
        // 1. 把AuthenticationToken转换为UserToken
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 2. 从UserToken中获取username
        String username = token.getUsername();
        // 3. 若用户不存在，抛出UnknownAccountException异常
        SysUser user = sysUserRepository.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        // 4. 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        return new SimpleAuthenticationInfo(user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName());
    }
}

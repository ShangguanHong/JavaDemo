package com.example.shiromultiplerealm.config.admin;

import com.example.shiromultiplerealm.config.UserToken;
import com.example.shiromultiplerealm.domain.SysAdmin;
import com.example.shiromultiplerealm.repository.SysAdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author sgh
 * @date 2019/8/19 下午9:43
 */
@Slf4j
public class AdminRealm extends AuthorizingRealm {

    @Resource
    private SysAdminRepository sysAdminRepository;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("AdminRealm---------------->doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 应该从数据库中读取并且采用缓存的机制
        // 这里为了简单就写死了
        info.addRole("admin");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("AdminRealm------------------->doGetAuthenticationInfo");
        // 1. 把AuthenticationToken转换为UserToken
        UserToken userToken = (UserToken) authenticationToken;
        // 2. 从UserToken中获取username
        String username = userToken.getUsername();
        // 3. 若用户不存在，抛出UnknownAccountException异常
        SysAdmin admin = sysAdminRepository.findByUsername(username);
        if (admin == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        // 4. 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        return new SimpleAuthenticationInfo(admin, admin.getPassword(), getName());
    }
}

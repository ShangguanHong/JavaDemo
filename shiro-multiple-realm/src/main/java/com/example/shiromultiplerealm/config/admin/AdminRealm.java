package com.example.shiromultiplerealm.config.admin;

import com.example.shiromultiplerealm.domain.SysAdmin;
import com.example.shiromultiplerealm.repository.SysAdminRepository;
import com.example.shiromultiplerealm.config.UserToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
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
        // TODO: 管理员权限赋予
        return null;
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

package com.example.shiromultiplerealm.config.user;

import com.example.shiromultiplerealm.config.UserToken;
import com.example.shiromultiplerealm.domain.SysUser;
import com.example.shiromultiplerealm.repository.UserInfoRepository;
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
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserInfoRepository userInfoRepository;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("UserRealm------------------->doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 应该从数据库中读取并且采用缓存的机制
        // 这里为了简单就写死了
        info.addRole("user");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("UserRealm---------------->doGetAuthenticationInfo");
        // 1. 把AuthenticationToken转换为UserToken
        UserToken userToken = (UserToken) authenticationToken;
        // 2. 从UserToken中获取username
        String username = userToken.getUsername();
        // 3. 若用户不存在，抛出UnknownAccountException异常
        SysUser user = userInfoRepository.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        // 4. 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}


package com.example.shiro.config.user;

import com.example.shiro.domain.UserInfo;
import com.example.shiro.repository.UserInfoRepository;
import com.example.shiro.config.UserToken;
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
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserInfoRepository userInfoRepository;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("UserRealm------------------->doGetAuthorizationInfo");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("UserRealm---------------->doGetAuthenticationInfo");
        // 1. 把AuthenticationToken转换为UserToken
        UserToken userToken = (UserToken) authenticationToken;
        // 2. 从UserToken中获取username
        String username = userToken.getUsername();
        // 3. 若用户不存在，抛出UnknownAccountException异常
        UserInfo user = userInfoRepository.findByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("用户不存在！");
        }
        // 4. 根据用户的情况，来构建AuthenticationInfo对象并返回，通常使用的实现类为SimpleAuthenticationInfo
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}


package com.example.shiromultiplerealm.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author sgh
 * @date 2019/8/19 下午9:51
 */
@Slf4j
public class UserModularRealmAuthenticator extends ModularRealmAuthenticator {

    /**
     * 自定义doAuthenticator
     */
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("UserModularRealmAuthenticator----------->doAuthenticate");
        // 强制转换回自定义的UserToken
        UserToken userToken = (UserToken) authenticationToken;
        // 获取登录类型
        String loginType = userToken.getLoginType();
        // 所有Realm
        Collection<Realm> realms = getRealms();
        // 登录类型对应的所有Realm
        Collection<Realm> typeRealms = new ArrayList<>();
        realms.forEach(realm -> {
            // 利用 realm 的全限定包名来进行判断
            if (realm.getName().contains(loginType)) {
                typeRealms.add(realm);
            }
        });
        if (typeRealms.size() == 1) {
            return doSingleRealmAuthentication(typeRealms.iterator().next(), userToken);
        } else {
            return doMultiRealmAuthentication(typeRealms, userToken);
        }
    }
}


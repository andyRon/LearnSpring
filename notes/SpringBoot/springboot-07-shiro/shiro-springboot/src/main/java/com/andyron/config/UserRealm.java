package com.andyron.config;

import com.andyron.pojo.User;
import com.andyron.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 *
 * @author Andy Ron
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;

    /**
     * 授权，认证后就会进入授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权===>doGetAuthorizationInfo");
        //
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");
        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证===>doGetAuthenticationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        User user = userService.queryUserByName(userToken.getUsername());

        if (user == null) {
            return null;    // null表示抛出异常 UnknownAccountException
        }

        // 可以加密：MD5   MD5盐值加密
        // 密码认证 shiro做
        return new SimpleAuthenticationInfo("", user.getPwd(), "");


    }
}

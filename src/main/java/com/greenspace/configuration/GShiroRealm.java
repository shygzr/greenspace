package com.greenspace.configuration;

import com.greenspace.model.AuthPermission;
import com.greenspace.model.AuthRole;
import com.greenspace.model.AuthUser;
import com.greenspace.model.User;
import com.greenspace.service.IAuthUserService;
import com.greenspace.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class GShiroRealm extends AuthorizingRealm{

    @Autowired
    private IAuthUserService authUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //System.out.println("GShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Optional<AuthUser> oAuthUser = authUserService.getUserByUserName(principals.getPrimaryPrincipal().toString());
        if(!oAuthUser.isPresent()){
            return null;
        }
        AuthUser authUser = oAuthUser.get();
        List<AuthPermission> userPermissions = authUserService.getUserPermissionByUserId(authUser.getId());
        List<AuthRole> authRoles = authUserService.getUserRoleListByUserId(authUser.getId());
        for(AuthPermission authPermission: userPermissions) {
            authorizationInfo.addStringPermission(authPermission.getPermCode());
        }
        for(AuthRole authRole: authRoles) {
            authorizationInfo.addRole(authRole.getRoleCode());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //System.out.println("GShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String userName = (String)token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        Optional<AuthUser> oAuthUser = authUserService.getUserByUserName(userName);
        if(!oAuthUser.isPresent()){
            return null;
        }
        AuthUser authUser = oAuthUser.get();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userName, //用户名
                authUser.getPassword(), //密码
                ByteSource.Util.bytes(userName + authUser.getSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}

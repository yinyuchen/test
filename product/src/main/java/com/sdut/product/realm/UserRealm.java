package com.sdut.product.realm;

import com.sdut.product.pojo.UserRole;
import com.sdut.product.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on  三月
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;

    /**
     * 提供用户信息，返回权限信息
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        String userName=(String) principals.getPrimaryPrincipal();
        String userId=loginService.findUserIdByName(userName);
        Set<UserRole> roleIdSet=loginService.findRoleIdByUid(userId);
        Set<String> roleSet=new HashSet<>();
        Set<String>  pemissionIdSet=new HashSet<>();
        Set<String>  pemissionSet=new HashSet<>();
        for(UserRole roleInfo : roleIdSet) {
            String roleId=roleInfo.getRoleId();
            roleSet.add( loginService.findRoleByRoleId( roleId ) );
            //将拥有角色的所有权限放进Set里面，也就是求Set集合的并集
            pemissionIdSet.addAll( loginService.findPermissionIdByRoleId( roleId ));
        }
        for(String permissionId : pemissionIdSet) {
            String permission= loginService.findPermissionById( permissionId );
            pemissionSet.add(  permission );
        }
         // 将角色名称提供给授权info
        authorizationInfo.setRoles( roleSet );
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(pemissionSet);

        return authorizationInfo;
    }

    /**
     * 提供帐户信息，返回认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName=(String)authenticationToken.getPrincipal();
        String password=loginService.selectByName(userName);
        if(password==null) {
            //用户不存在就抛出异常
            throw new UnknownAccountException();
        }
        //密码可以通过SimpleHash加密，然后保存进数据库。
        //此处是获取数据库内的账号、密码、盐值，保存到登陆信息info中
        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(userName,password, "myShiroRealm");
//                SimpleAuthenticationInfo(user.getUserName(), user.getPassword(),ByteSource.Util.bytes(user.getSalt()),getName());                   //realm name

        return authenticationInfo;
    }
}

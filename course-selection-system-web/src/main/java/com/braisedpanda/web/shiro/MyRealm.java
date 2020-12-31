package com.braisedpanda.web.shiro;


import com.braisedpanda.model.entity.SysUser;
import com.braisedpanda.system.service.SysUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;



/**
 * 自定义shiro域
 * @author ThinkPad
 */
@Component
public class MyRealm extends AuthorizingRealm {

    @Reference(version = "1.0")
    private SysUserService sysUserService;


    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("========开始权限验证========");
        SysUser user = (SysUser)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //查询登录用户所拥有的角色，并添加角色
        info.addRole("admin");
        info.addStringPermission("permission");
        return info;

    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws UnauthorizedException {
        System.out.println("========开始身份验证========");
        String username = (String) auth.getPrincipal();
        String password = new String((char[]) auth.getCredentials());
        SysUser user = sysUserService.selectUserByUsernameAndPassword(username,password);
        if (user == null) {
            throw new AuthenticationException("用户名或密码错误");
        }
        return new SimpleAuthenticationInfo(user, password, getName());
    }

}

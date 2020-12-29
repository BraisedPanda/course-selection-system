package com.braisedpanda.web.shiro;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
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



    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

//        Integer userNo = JWTUtil.getUserId(principals.toString());
//        SysUser user = userService.cacheUserById(userNo);
//        //获取用户角色信息
//        List<SysUserRole> userToRole = userToRoleService.getUserRoles(user.getId());
//
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        Set<String> permission = new HashSet<>();
//        List<Integer> roles = new ArrayList<>();
//        userToRole.forEach(userRole -> roles.add(userRole.getRoleId()));
//        List<SysModule> menuList = menuService.findMenuByRoleCode(roles);
//        for (SysModule per : menuList) {
//            if (!StringUtils.isEmpty(per.getModuleCode())) {
//                permission.add(String.valueOf(per.getModuleCode()));
//            }
//        }
//        simpleAuthorizationInfo.addStringPermissions(permission);
//        return simpleAuthorizationInfo;
        return null;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws UnauthorizedException {

//        String tokenParam = RequestHolder.getRequest().getParameter("Authorization");
//        String token = (String) auth.getCredentials();
//        // 解密获得username，用于和数据库进行对比
//        if (StringUtils.isEmpty(token) && StringUtils.isEmpty(tokenParam) ) {
//            throw new UnauthorizedException("token invalid");
//        }
//
//        Integer userId = JWTUtil.getUserId(token);
//        if (userId == null) {
//            throw new UnauthorizedException("token invalid");
//        }
//        //缓存时间超时
//        if (userService.getUserIdCache(userId) == null) {
//            throw new LogicException(ResponseEnum.SESSION_TIMEOUT_ERROR);
//        }
//        //zhenpeng.wang 2019年3月15日10:34:04 单点登陆判断
//        String cacheToken = userService.getUserIdCache(userId);
//        if (cacheToken != null) {
//            //已经有缓存了，并且不一样，此处返回提示是否需要处理
//            if (!cacheToken.equalsIgnoreCase(token)) {
//                throw new LogicException(ResponseEnum.OFFSITE_LOGIN_EXCEPTION);
//            }
//        }
//        SysUser userBean = userService.getId(userId);
//        if (userBean == null) {
//            //避免爆破出用户名 返回信息模糊化
//            throw new UnauthorizedException("Username or password error");
//        }
//        boolean verifyFlag = JWTUtil.verify(token, userId, userBean.getPassword());
//        HttpServletResponse response = RequestHolder.getResponse();
//        try {
//            //如果没有异常，设置不需要刷新token，重新缓存当前token
//            response.setHeader("RefreshToken", "false");
//            userService.putUserIdCache(userId, token);
//        } catch (TokenExpiredException expire) {
//            //过期了，但是前两项正确，先检查是否在本次会话中，如果存在重新sign
//            String newToken = JWTUtil.sign(userId, userBean.getPassword());
//            response.setHeader("RefreshToken", "true");
//            response.setHeader("Token", newToken);
//            userService.delTokenCache(token);
//            userService.putUserIdCache(userId, token);
//            verifyFlag = true;
//        }
//        if (!verifyFlag) {
//            throw new UnauthorizedException("Username or password error");
//        }
//        //验证通过时，存入用户信息到session中，应用系统使用
//        if (ObjectUtils.isNotEmpty(cacheManagerService.getOrgCache(userBean.getOrgId()))) {
//            userBean.setManagementLevel(cacheManagerService.getOrgCache(userBean.getOrgId()).getLevel().toString());
//        }
//        RequestHolder.getRequest().getSession().setAttribute("userInfo", userBean);
//        RequestHolder.getRequest().getSession().setAttribute("userId", JWTUtil.getUserId(token));
//        return new SimpleAuthenticationInfo(token, token, this.getName());
        return null;
    }

}

package com.braisedpanda.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.braisedpanda.model.entity.SysUser;
import com.braisedpanda.system.mapper.SysUserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: course-selection-system
 * @description:
 * @author: chenzhen
 * @create: 2020-12-29 17:26
 **/
@Service(version = "1.0")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 分页查询用户信息
     * @param page 分页条件
     * @param sysUser 查询条件
     * @return com.braisedpanda.model.ResponseStatus
     * @author chenzhen
     * @date 2020/12/29 0029
     */
    @Override
    public Page<SysUser> selectSysUserPage(Page<SysUser> page, SysUser sysUser) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(SysUser::getId);
        return sysUserMapper.selectPage(page, lambdaQueryWrapper);
    }

    /**
     * 根据用户名密码查找账户
     * @param loginAccount 登录用户名
     * @param password 登录密码
     * @return com.braisedpanda.model.entity.SysUser
     * @author chenzhen
     * @date 2020/12/29 0029
     */
    @Override
    public SysUser selectUserByUsernameAndPassword(String loginAccount, String password) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getLoginAccount, loginAccount);
        lambdaQueryWrapper.eq(SysUser::getPassword, password);
        SysUser user = sysUserMapper.selectOne(lambdaQueryWrapper);
        return user;
    }
}

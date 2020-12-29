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

    @Override
    public Page<SysUser> selectSysUserPage(Page<SysUser> page, SysUser sysUser) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(SysUser::getId);
        return sysUserMapper.selectPage(page, lambdaQueryWrapper);
    }
}

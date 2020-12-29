package com.braisedpanda.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.braisedpanda.model.entity.SysUser;

/**
* 用户Service
* @param
* @return
* @author chenzhen
* @date 2020/12/29 0029
*/
public interface SysUserService extends IService<SysUser> {

    /**
     * 分页查询用户信息
     * @param page 分页条件
     * @param sysUser 查询条件
     * @return com.braisedpanda.model.ResponseStatus
     * @author chenzhen
     * @date 2020/12/29 0029
     */
    Page<SysUser> selectSysUserPage(Page<SysUser> page, SysUser sysUser);
}

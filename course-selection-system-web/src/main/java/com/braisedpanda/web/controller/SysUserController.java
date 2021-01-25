package com.braisedpanda.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.braisedpanda.model.ResponseStatus;
import com.braisedpanda.model.entity.SysUser;
import com.braisedpanda.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @program: course-selection-system
 * @description:
 * @author: chenzhen
 * @create: 2020-11-02 15:01
 **/
@RestController
@RequestMapping("/sys-user")
@Api(value = "/sys-user", tags = {"用户模块"})
public class SysUserController {

    @Reference(version="1.0")
    private SysUserService sysUserService;

    /**
    * 分页查询用户信息
    * @param page 分页条件
    * @param sysUser 查询条件
    * @return com.braisedpanda.model.ResponseStatus
    * @author chenzhen      
    * @date 2020/12/29 0029
    */ 
    @GetMapping("page")
    @ApiOperation("分页查询用户信息")
    public ResponseStatus page(Page<SysUser> page, SysUser sysUser){
        return ResponseStatus.success(sysUserService.selectSysUserPage(page, sysUser));
    }

    @GetMapping("/")
    public ModelAndView toIndex(){
        return new ModelAndView("login");
    }

}

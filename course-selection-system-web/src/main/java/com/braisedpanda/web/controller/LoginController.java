package com.braisedpanda.web.controller;


import com.braisedpanda.model.entity.SysUser;
import com.braisedpanda.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @program: course-selection-system
 * @description:
 * @author: chenzhen
 * @create: 2020-11-02 15:01
 **/
@Controller
@Api(tags = {"登录模块"})
public class LoginController {

    @Reference(version="1.0")
    private SysUserService sysUserService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public ModelAndView login(String username, String password, HttpSession session){
        ModelAndView courseModelAndView = new ModelAndView();
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            courseModelAndView.addObject("tips","未知账户~");
            courseModelAndView.setViewName("login");
            return courseModelAndView;
        } catch (IncorrectCredentialsException ice) {
            courseModelAndView.addObject("tips","密码不正确~");
            courseModelAndView.setViewName("login");
            return courseModelAndView;
        } catch (LockedAccountException lae) {
            courseModelAndView.addObject("tips","账户已锁定~");
            courseModelAndView.setViewName("login");
            return courseModelAndView;
        } catch (ExcessiveAttemptsException eae) {
            courseModelAndView.addObject("tips","用户名或密码错误次数过多~");
            courseModelAndView.setViewName("login");
            return courseModelAndView;
        } catch (AuthenticationException ae) {
            courseModelAndView.addObject("tips",ae.getMessage());
            courseModelAndView.setViewName("login");
            return courseModelAndView;
        }
        if (subject.isAuthenticated()) {
            SysUser user = sysUserService.selectUserByUsernameAndPassword(username,password);
            session.setAttribute("user",user);
            courseModelAndView.setViewName("index");
            return courseModelAndView;
        } else {
            token.clear();
            courseModelAndView.addObject("tips","*未知账户~");
            courseModelAndView.setViewName("login");
            return courseModelAndView;
        }
    }

    @GetMapping("/logout")
    @ApiOperation("用户登出")
    public String quite(HttpSession session){
        session.removeAttribute("user");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/";
    }

}

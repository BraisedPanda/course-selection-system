package com.braisedpanda.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.braisedpanda.model.ResponseStatus;
import com.braisedpanda.model.entity.SysUser;
import com.braisedpanda.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: course-selection-system
 * @description:
 * @author: chenzhen
 * @create: 2020-11-02 15:01
 **/
@RestController
@RequestMapping("/sys-user")
@Api(value = "/sys-user", tags = {"用户模块"})
public class LoginController {

    @Reference(version="1.0")
    SysUserService studentService;

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
        return ResponseStatus.success(studentService.selectSysUserPage(page, sysUser));
    }

//    @PostMapping("/login")
//    @ApiOperation("用户登录")
//    public ModelAndView login(String username, String password, HttpSession session){
//        ModelAndView modelAndView = new ModelAndView();
//        // 从SecurityUtils里边创建一个 subject
//        Subject subject = SecurityUtils.getSubject();
//        // 在认证提交前准备 token（令牌）
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        // 执行认证登陆
//        try {
//            subject.login(token);
//        } catch (UnknownAccountException uae) {
//            modelAndView.addObject("tips","*未知账户~");
//            modelAndView.setViewName("index");
//            return modelAndView;
//        } catch (IncorrectCredentialsException ice) {
//            modelAndView.addObject("tips","*密码不正确~");
//            modelAndView.setViewName("index");
//            return modelAndView;
//        } catch (LockedAccountException lae) {
//            modelAndView.addObject("tips","*账户已锁定~");
//            modelAndView.setViewName("index");
//            return modelAndView;
//        } catch (ExcessiveAttemptsException eae) {
//            modelAndView.addObject("tips","*用户名或密码错误次数过多~");
//            modelAndView.setViewName("index");
//            return modelAndView;
//        } catch (AuthenticationException ae) {
//            modelAndView.addObject("tips","*用户名或密码不正确~");
//            modelAndView.setViewName("index");
//            return modelAndView;
//        }
//        if (subject.isAuthenticated()) {
//            User user = userService.selectUserByUsernameAndPasword(username,password);
//            session.setAttribute("user",user);
//            modelAndView.setViewName("menu/main");
//            return modelAndView;
//        } else {
//            token.clear();
//            modelAndView.addObject("tips","*未知账户~");
//            modelAndView.setViewName("index");
//            return modelAndView;
//        }
//    }

    @GetMapping("/")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }

}

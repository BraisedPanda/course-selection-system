package com.braisedpanda.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: course-selection-system
 * @description: 跳转Controller
 * @author: chenzhen
 * @create: 2020-12-09 14:31
 **/
@RestController
@Api(tags = {"页面跳转接口"})
public class PageController {

    @GetMapping("/index")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }

    @GetMapping("/main")
    public ModelAndView toMain(){
        return new ModelAndView("main");
    }

    @GetMapping("/chat")
    public ModelAndView toChat(){
        return new ModelAndView("chat");
    }

    @GetMapping("/login")
    @ApiOperation("跳转到登录页面")
    public ModelAndView toLoginPage(){
        return new ModelAndView("login");
    }

    @GetMapping("/alerts")
    public ModelAndView toAlerts(){
        return new ModelAndView("components_alerts");
    }

}

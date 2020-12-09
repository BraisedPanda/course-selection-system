package com.braisedPanda.web.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: course-selection-system
 * @description:
 * @author: chenzhen
 * @create: 2020-11-02 15:01
 **/
@RestController
@Api("登录接口")
public class LoginController {



    @GetMapping("/")
    public ModelAndView toIndex(){
        return new ModelAndView("/index");
    }

}

package com.braisedpanda.web.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @program: course-selection-system
 * @description: 跳转Controller
 * @author: chenzhen
 * @create: 2020-12-09 14:31
 **/
@RestController
@RequestMapping("/page")
@Api(value = "/page", tags = {"页面跳转接口"})
public class PageController {

    @GetMapping("/toIndex")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }

    @GetMapping("/toMain")
    public ModelAndView toMain(){
        return new ModelAndView("main");
    }

    @GetMapping("/toChat")
    public ModelAndView toChat(){
        return new ModelAndView("chat");
    }

    @GetMapping("/toDataTables")
    public ModelAndView toDataTables(){
        return new ModelAndView("tables/tables-datatables");
    }

}

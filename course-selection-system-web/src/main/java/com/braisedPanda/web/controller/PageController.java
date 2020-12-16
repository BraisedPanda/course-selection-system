package com.braisedPanda.web.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/toDashboard4")
    public ModelAndView toDashboard4(){
        return new ModelAndView("dashboard/dashboard-4");
    }

    @GetMapping("/toDashboard2")
    public ModelAndView toDashboard2(){
        return new ModelAndView("dashboard/dashboard-2");
    }

    @GetMapping("/toDataTables")
    public ModelAndView toDataTables(){
        return new ModelAndView("tables/tables-datatables");
    }

}

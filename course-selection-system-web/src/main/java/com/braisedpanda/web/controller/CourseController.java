package com.braisedpanda.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.braisedpanda.course.service.IInfoCourseService;
import com.braisedpanda.model.ResponseStatus;
import com.braisedpanda.model.entity.InfoCourse;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @program: course-selection-system
 * @description: 课程功能Controller
 * @author: chenzhen
 * @create: 2021-02-24 22:12
 **/
public class CourseController {

    @Reference
    private IInfoCourseService infoCourseService;

    public ResponseStatus courseArrange(String courseIds, String courseType){
        List<String> idList = new ArrayList<>(Arrays.asList(courseIds.split(",")));
        LambdaQueryWrapper<InfoCourse> courseLambdaQueryWrapper1 = new LambdaQueryWrapper<>();
        infoCourseService.list(courseLambdaQueryWrapper1);
        return null;
    }

    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(i);
            list.add("课程"+(i+1));
        }
        int count = 10;
        List<String> resultList = new ArrayList<>();
        Random random = new Random();
        while(count >= 1){
            int num = random.nextInt(count);
            // 真实list中下标
            int array = numberList.get(num);
            numberList.remove(num);
            String a = "上课时间点"+array+" : " + list.get(array);

            resultList.add(a);
            count--;
        }
        System.out.println(resultList);
    }
}

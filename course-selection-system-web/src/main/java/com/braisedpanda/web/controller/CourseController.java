package com.braisedpanda.web.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: course-selection-system
 * @description: 课程功能Controller
 * @author: chenzhen
 * @create: 2021-02-24 22:12
 **/
public class CourseController {

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

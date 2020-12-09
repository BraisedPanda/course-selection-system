package com.braisedPanda.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @program: course-selection-system
 * @description:
 * @author: chenzhen
 * @create: 2020-11-02 11:34
 **/

@SpringBootApplication
@EnableDubbo
public class WebSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSpringBootApplication.class, args);
    }
}

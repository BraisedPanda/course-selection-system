package com.braisedpanda.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;


/**
 * @program: course-selection-system
 * @description:
 * @author: chenzhen
 * @create: 2020-11-02 11:34
 **/

@SpringBootApplication(exclude = {FeignAutoConfiguration.class, DataSourceAutoConfiguration.class} )
@EnableDiscoveryClient
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}

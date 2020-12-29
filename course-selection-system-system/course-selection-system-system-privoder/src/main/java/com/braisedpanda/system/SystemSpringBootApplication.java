package com.braisedpanda.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: course-selection-system
 * @description:
 * @author: chenzhen
 * @create: 2020-12-29 17:16
 **/
@EnableDiscoveryClient
@EnableAutoConfiguration
public class SystemSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemSpringBootApplication.class, args);
    }
}

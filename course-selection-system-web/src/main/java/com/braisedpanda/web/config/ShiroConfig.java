
package com.braisedpanda.web.config;


import com.braisedpanda.web.shiro.MyRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author: wei.cao@ingeek.com
 * @date: 2018年11月12日16:30:09
 * @description: shiro 配置类
 */

@Configuration
public class ShiroConfig {
    @Bean("courseShiroFilter")
    public ShiroFilterFactoryBean courseShiroFilter(SecurityManager courseSecurityManager) {
        ShiroFilterFactoryBean courseShiroFilterFactoryBean = new ShiroFilterFactoryBean();
        courseShiroFilterFactoryBean.setSecurityManager(courseSecurityManager);

        // 没有登录时，跳转至登录页面
        courseShiroFilterFactoryBean.setLoginUrl("/login");
        // 没有任何授权时，跳转至未授权界面
        courseShiroFilterFactoryBean.setUnauthorizedUrl("/notRole");
        // 创建拦截器
        Map<String, String> courseFilterChainDefinitionMap = new LinkedHashMap<>();
        // 自定义拦截器拦截的url
        courseFilterChainDefinitionMap.put("/page/**", "anon");
        courseFilterChainDefinitionMap.put("/login/**", "anon");
        courseFilterChainDefinitionMap.put("/403", "anon");
        // 放行静态资源
        courseFilterChainDefinitionMap.put("/assets/**", "anon");
        courseFilterChainDefinitionMap.put("/images/**", "anon");

        // 放开swagger接口文档
        courseFilterChainDefinitionMap.put("/webjars/**", "anon");
        courseFilterChainDefinitionMap.put("/swagger-resources", "anon");
        courseFilterChainDefinitionMap.put("/v2/api-docs", "anon");
        courseFilterChainDefinitionMap.put("/doc.html", "anon");

        Map<String, Filter> filterMap = new HashMap<>(1);
        courseShiroFilterFactoryBean.setFilters(filterMap);

        courseFilterChainDefinitionMap.put("/**", "authc");
//        filterChainDefinitionMap.put("/**", "anon");
        //未授权界面;
        courseShiroFilterFactoryBean.setUnauthorizedUrl("/error/404");
        courseShiroFilterFactoryBean.setFilterChainDefinitionMap(courseFilterChainDefinitionMap);
        return courseShiroFilterFactoryBean;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean("securityManager")
    public SecurityManager securityManager(MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        /*
         * 关闭shiro自带的session，详情见文档
         * http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);
        return securityManager;
    }

    @Bean
    @DependsOn({"securityManager"})
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}

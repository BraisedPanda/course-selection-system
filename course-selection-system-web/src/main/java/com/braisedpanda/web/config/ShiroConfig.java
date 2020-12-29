
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
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/login/**", "anon");
        filterChainDefinitionMap.put("/403", "anon");
        filterChainDefinitionMap.put("/408", "anon");
        filterChainDefinitionMap.put("/verificationCode", "anon");
        filterChainDefinitionMap.put("/verificationCodeSms", "anon");
        filterChainDefinitionMap.put("/sys-user/findLoginName", "anon");
        filterChainDefinitionMap.put("/sys-user/forgetPassword", "anon");
        filterChainDefinitionMap.put("/sys-user/getCode", "anon");
        filterChainDefinitionMap.put("/sys-user/validateCode", "anon");
        filterChainDefinitionMap.put("/sys-user/setNewPassword", "anon");
        //filterChainDefinitionMap.put("/sys-user/newPassword", "anon");
        filterChainDefinitionMap.put("/biz-params/bizparams-list/**", "anon");
        filterChainDefinitionMap.put("/biz-params/bizparams-sublist/**", "anon");
        filterChainDefinitionMap.put("/biz-params/bizSubParams/**", "anon");

        filterChainDefinitionMap.put("/common/orgs/**", "anon");
        filterChainDefinitionMap.put("/common/dropDownDicts/**", "anon");
        filterChainDefinitionMap.put("/sys-dept/**/depts", "anon");
        filterChainDefinitionMap.put("/sys-user/register", "anon");
        filterChainDefinitionMap.put("/sys-role/allroles/**", "anon");
        filterChainDefinitionMap.put("/common/country", "anon");
        filterChainDefinitionMap.put("/common/**/region", "anon");

        // TODO 公共接口，暂时放行
        filterChainDefinitionMap.put("/common/auditor", "anon");
        filterChainDefinitionMap.put("/common/file/**", "anon");
        filterChainDefinitionMap.put("/common/user", "anon");
        filterChainDefinitionMap.put("/sys-org/level", "anon");
        filterChainDefinitionMap.put("/sys-org/secondary", "anon");

        //放开定时任务相关接口
        filterChainDefinitionMap.put("/job-information-synchroniz/**", "anon");
        filterChainDefinitionMap.put("/job-information-remind/restart/**", "anon");

        //放开第三方推送接口
        filterChainDefinitionMap.put("/interface/**", "anon");
        filterChainDefinitionMap.put("/asset-interface/**", "anon");

        // 放开swagger接口文档
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/doc.html", "anon");

        // 添加自己的过滤器并且取名为jwt
        Map<String, Filter> filterMap = new HashMap<>(1);
        shiroFilterFactoryBean.setFilters(filterMap);

        filterChainDefinitionMap.put("/**", "anon");


        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/csmp/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
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

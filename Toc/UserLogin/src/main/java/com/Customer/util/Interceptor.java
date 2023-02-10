package com.Customer.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * PROJECT_NAME Interceptor
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/2/8~21:53
 */
@Configuration
public class Interceptor implements WebMvcConfigurer {

    @Resource
    JWT jwtInterceptor;

    /**
     * @param registry 拦截器 的 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 把 拦截器 注册到 Mvc, 同时 设置 拦截 和 放过的 信息
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login").excludePathPatterns("/user/loginGetMailCode")
                .excludePathPatterns("/user/loginGetMessageCode").excludePathPatterns("/user/register/**");

    }

}

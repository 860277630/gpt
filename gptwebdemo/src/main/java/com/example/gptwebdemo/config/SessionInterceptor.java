package com.example.gptwebdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SessionInterceptor
 *
 * @author 10905 2019/1/23
 * @version 1.0
 */
@Configuration
public class SessionInterceptor implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("开启拦截器@Configuration拦截配置----------------------session拦截-----------------------凡是路径有/admin/都要经过拦截器--------------");
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/gpt/**");
    }
}
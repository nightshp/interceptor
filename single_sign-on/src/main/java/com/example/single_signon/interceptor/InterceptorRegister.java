package com.example.single_signon.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：nightwalker
 * @date ：Created in 19-11-24 下午1:50
 * @description：注册拦截器
 * @version: $
 */
@Configuration
public class InterceptorRegister implements WebMvcConfigurer {

    @Autowired
    private SingleUserInterceptor singleUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(singleUserInterceptor).addPathPatterns("/**").excludePathPatterns("/query", "/checkUser");

    }
}

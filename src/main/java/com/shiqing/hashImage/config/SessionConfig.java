package com.shiqing.hashImage.config;

import com.shiqing.hashImage.interceptor.SessionInceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author：xiaoyu
 * @create： 14:00 2019/5/11
 * @description:
 */
@Configuration
public class SessionConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInceptor()).addPathPatterns("/back/*");
    }
}

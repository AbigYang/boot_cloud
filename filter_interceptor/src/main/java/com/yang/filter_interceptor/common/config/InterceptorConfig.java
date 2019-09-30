package com.yang.filter_interceptor.common.config;

import com.yang.filter_interceptor.common.intercepto.LogCostInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 将原来的继承WebMvcConfigurerAdapter类改为实现WebMvcConfigurer接口 拒绝中间商赚差价
 *
 * @Author rycoyang
 * @Date 2019/9/30 10:19
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/**");
    }
}

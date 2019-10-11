package com.yang.filter_interceptor.common.config;

import com.yang.filter_interceptor.common.intercepto.LogCostInterceptor;
import com.yang.filter_interceptor.common.intercepto.RouterInterceptor;
import org.springframework.context.annotation.Bean;
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

    //RouterInterceptor 之前就初始化service
    @Bean
    public RouterInterceptor getInterceptor() {
        System.out.println("初始化RouterInterceptor");
        return new RouterInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogCostInterceptor()).addPathPatterns("/yes/**");
        registry.addInterceptor(getInterceptor()).addPathPatterns("/happly/**");
    }
}

package com.yang.filter_interceptor.common.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 通过注解方式完成配置
 * 注意：@WebFilter这个注解是Servlet3.0的规范，并不是Spring boot提供的。
 * 除了这个注解以外，我们还需在配置类中加另外一个注解：@ServletComponetScan，指定扫描的包
 *
 * @Author rycoyang
 * @Date 2019/9/30 9:56
 **/
//@WebFilter(urlPatterns = "/*", filterName = "logFilter2")
public class LogCostFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        System.out.println("logFilter2开始了");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("logFilter2耗时：" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {

    }
}

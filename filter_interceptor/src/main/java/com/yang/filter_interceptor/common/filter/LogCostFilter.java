package com.yang.filter_interceptor.common.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 过滤器 实现Filter 依赖于Servlet，由Servlet回调完成，生命周期由servlet容器管理
 *
 * @Author rycoyang
 * @Date 2019/9/30 9:43
 **/
public class LogCostFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        System.out.println("Filter开始了");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter耗时：" + (System.currentTimeMillis() - start));
    }

    @Override
    public void destroy() {

    }
}

package com.yang.filter_interceptor.common.intercepto;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author rycoyang
 * @Date 2019/9/30 10:08
 **/
public class LogCostInterceptor implements HandlerInterceptor {

    long start = System.currentTimeMillis();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle cost:" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        return true;
    }

    /**
     * preHandle return true
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle cost:" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion cost:" + (System.currentTimeMillis() - start));
    }
}

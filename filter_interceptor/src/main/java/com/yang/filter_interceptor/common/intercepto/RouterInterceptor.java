package com.yang.filter_interceptor.common.intercepto;

import com.yang.filter_interceptor.controller.HapplyController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * /happly/yep 路由至 /happly/nop
 *
 * @Author rycoyang
 * @Date 2019/10/10 16:51
 **/
public class RouterInterceptor implements HandlerInterceptor {

    @Resource
    private HapplyController happlyController;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (request.getRequestURI().indexOf("/happly/yep") == 0) {

            //无法注入是因为RouterInterceptor是new的，不是交给Spring管理的bean,WebApplicationContextUtils
            if (happlyController == null) {//解决service为null无法注入问题
                System.out.println("happlyController is null!!!");
                BeanFactory factory = WebApplicationContextUtils
                        .getRequiredWebApplicationContext(request.getServletContext());
                happlyController = (HapplyController) factory
                        .getBean(HapplyController.class);
            } else
                System.out.println("happlyController is not null!!!");

            happlyController.getNop();
        }


        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}

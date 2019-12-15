package com.system.module2.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: dapeng_lgq
 * @since:JDK-1.8
 * @author: Star-GuoqingLi
 * @create: 2019-12-14 22:18
 * @version:第1版
 * @description: 登录拦截器
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {

    //目标方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object emp = request.getSession().getAttribute("emp");
        if (emp == null){ //未登录
            response.sendRedirect("/login");
            return false;
        }else { //已经登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

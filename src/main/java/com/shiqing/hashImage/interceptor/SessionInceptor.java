package com.shiqing.hashImage.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author：xiaoyu
 * @create： 13:57 2019/5/11
 * @description:
 */
public class SessionInceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //普通路径放行
        if ("/back/login".equals(request.getRequestURI())) {
            return true;
        }
        //权限路径拦截
        Object object = request.getSession().getAttribute("userId");
        if (null == object) {
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
}

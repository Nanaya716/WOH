package com.jxc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;

/**
 * 拦截器：对用户权限进行验证，无身份信息则进入登录页面，否则继续访问相应服务
 */
public class AuthInterceptor implements HandlerInterceptor {
    String[] paths = new String[]{
            "toLogin"
    };
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean chain = HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
        //1.过滤请求地址（如果配置信息中已加exclude-mapping配置，这里就可以省略）
        /*String url= request.getRequestURI();
        if(Arrays.asList(paths).contains(url)){
            return true;
        }
        //2.身份验证
        HttpSession httpSession = request.getSession();
        if(httpSession.getAttribute("user")!=null){
            return true;
        }
        //request.setAttribute("msg","请先登录！");
        //request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
        //3.跳转到登录页面（建议使用页面重定向）
        response.sendRedirect("/toLogin");
        return chain;*/
    }
}

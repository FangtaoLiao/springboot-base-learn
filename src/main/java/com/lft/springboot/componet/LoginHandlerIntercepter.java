package com.lft.springboot.componet;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录检查
 */
public class LoginHandlerIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        Object user=request.getSession().getAttribute("loginUser");
        if(user==null){
            //not sign in
            request.setAttribute("msg","没有登录，请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //sign in,success
            return true;
        }
    }
}
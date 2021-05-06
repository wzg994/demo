package com.wzg.config;

import com.wzg.demo.util.Result;
import com.wzg.demo.util.ResultUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的session
        Object loginUser = request.getSession().getAttribute("LoginUser");

        if (loginUser==null){
            this.perHandle(request,response,handler);
            request.setAttribute("msg","没有权限，请先登录");
            return false;
//            request.getRequestDispatcher()
        }else{
            this.perHandle(request,response,handler);
            return true;
        }
//        return false;
    }

    public Result perHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        //登录成功之后，应该有用户的session
        Object loginUser = request.getSession().getAttribute("LoginUser");

        if (loginUser==null){
            request.setAttribute("msg","没有权限，请先登录");
            return ResultUtil.error("400","没有权限，请先登录\"");
//            request.getRequestDispatcher()
        }else{
            System.out.println("Debug==>成功");
            return ResultUtil.success();
        }
    }
}

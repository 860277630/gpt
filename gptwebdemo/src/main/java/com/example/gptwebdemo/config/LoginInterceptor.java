package com.example.gptwebdemo.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * LoginInterceptor
 * 拦截器配置
 *
 * @author 10905 2019/1/23
 * @version 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {


    //在请求处理之前进行调用（Controller方法调用之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("session情况:   "+(request.getSession().getAttribute("user")));
        System.out.println("cookies情况：");
        for (Cookie cookie : request.getCookies()) {
            System.out.println("===name==="+cookie.getName()+"===value==="+cookie.getValue());
        }
        if (null!=request.getSession().getAttribute("user")) {
            System.out.println("登录请求的用户名和密码和数据库验证OK-----");
            System.out.println("有session==>" + request.getSession() + "=====通行"+request.getSession().getAttribute("userName"));
            //            放行为true,反之拦截
            return true;
        }
        System.out.println("和数据库数据不一致,请重新登录");
        System.out.println("-----------自定义拦截器------------拦截住了----------");

        response.setCharacterEncoding("UTF-8");//解决???编码形式乱码
        response.setContentType("text/html;charset=utf-8");// 解决printWriter.write就不会乱码了,鏃堕棿杩囨湡,璇烽噸鏂扮櫥褰乱码
        //response.setContentType("text/json");//响应json格式
        PrintWriter printWriter = response.getWriter();//主要修改了编码之后再获取流对象

        printWriter.write("please login again! session时间过期,请重新登录 http://localhost:8081/gologin");
        //printWriter.write(JSON.toJSONString(jr));//需要返回json的写法
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
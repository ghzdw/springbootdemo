package com.example.day03_emp.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Resource
    private FreeMarkerViewResolver freeMarkerViewResolver;
    private  static Logger logger= LoggerFactory.getLogger(AuthInterceptor.class);
    public  AuthInterceptor(){
        logger.info("权限拦截器构造函数执行");
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object admin = request.getSession().getAttribute("admin");
//        System.out.println(freeMarkerViewResolver.getOrder());//测试直接通过new AuthInterceptor()的方式添加拦截器无法注入
        if (admin == null) {
            request.getRequestDispatcher("/").forward(request,response);
            return  false;
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}

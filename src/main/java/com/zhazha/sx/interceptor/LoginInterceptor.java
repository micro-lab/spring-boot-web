package com.zhazha.sx.interceptor;

import com.zhazha.sx.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("------preHandle------");
        //获取session
        User user = (User)httpServletRequest.getSession().getAttribute("user");
        //判断用户ID是否存在，不存在就跳转到登录界面
        if(user == null){
            logger.info("------:跳转到login页面！");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/welcome");
            return false;
        }else{
            httpServletRequest.getSession().setAttribute("user", user);
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
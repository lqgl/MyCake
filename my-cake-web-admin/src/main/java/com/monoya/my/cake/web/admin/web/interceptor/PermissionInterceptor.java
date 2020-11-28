package com.monoya.my.cake.web.admin.web.interceptor;

import com.monoya.my.cake.commons.constants.ConstantUtils;
import com.monoya.my.cake.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截不登陆访问
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //以 login 结尾的请求
        if(modelAndView != null&& modelAndView.getViewName() != null &&modelAndView.getViewName().endsWith("login")) {
            User user = (User) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (user != null) {
                httpServletResponse.sendRedirect("/main");
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

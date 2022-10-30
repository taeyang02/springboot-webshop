package com.example.ShowMakerCode.HandlerInterceptor;

import com.example.ShowMakerCode.Constant.SessionAttr;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String isUrl = request.getRequestURI();
        String RoleAccount = (String) request.getSession().getAttribute(SessionAttr.ROLE_ACCOUNT);

        if (request.getSession().getAttribute(SessionAttr.CURRENT_USER)==null){
            response.sendRedirect("/smk/site/login");
            return false;
        }
        if (!RoleAccount.equals("admin") && !isUrl.substring(0,14).equals("/smk/card/add/")){
            response.sendRedirect("/smk/homepage");
            return false;
        }
    return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}

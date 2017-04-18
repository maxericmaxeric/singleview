package com.ecsolutions;

import com.ecsolutions.entity.User_Entity;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/1.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("loginInterceptor: " + request.getRequestURI());
        User_Entity user = (User_Entity)request.getSession().getAttribute("CURRENT_USER");
        if (user != null) {
            String adminflag = user.getAdminflag();
            String url = request.getRequestURI();
            if (adminflag.equals("Y") && url.startsWith("/admin"))
                return true;
            else if (adminflag.equals("N") && url.startsWith("/user"))
                return true;
            else if (url.startsWith("/logout"))
                return true;
        }

        response.sendRedirect("/login?next=".concat(request.getRequestURI()));
        return false;
    }
}

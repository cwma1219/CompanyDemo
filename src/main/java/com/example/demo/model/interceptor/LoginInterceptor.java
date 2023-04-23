package com.example.demo.model.interceptor;

import com.example.demo.model.pojo.Result;
import com.example.demo.model.utils.JwtUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@CrossOrigin

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equals(request.getMethod().toUpperCase()))
            return true;
        String jwt = request.getHeader("token");
        if (jwt == ""||jwt == null){
            String msg =  new JSONObject(Result.error("NOT_LOGIN")).toString();
            response.getWriter().write(msg);
            return false;
        }
        try{
            JwtUtils.parseJwt(jwt);
        }catch (Exception e){
            String msg =  new JSONObject(Result.error("NOT_LOGIN")).toString();
            response.getWriter().write(msg);
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

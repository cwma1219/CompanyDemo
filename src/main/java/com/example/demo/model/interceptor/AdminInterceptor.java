package com.example.demo.model.interceptor;

import com.example.demo.model.annotation.AuthCheckApi;
import com.example.demo.model.pojo.Result;
import com.example.demo.model.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if("OPTIONS".equals(request.getMethod().toUpperCase()))
            return true;
        AuthCheckApi authCheckApi = ((HandlerMethod)handler).getMethodAnnotation(AuthCheckApi.class);
        if(authCheckApi == null)
            return true;
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(jwt);
        Integer position = Integer.parseInt(claims.get("position").toString());
        if(position.equals(1)){
            return true;
        }
        else{
            String msg = new JSONObject(Result.error("Not an administrator")).toString();
            response.getWriter().write(msg);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

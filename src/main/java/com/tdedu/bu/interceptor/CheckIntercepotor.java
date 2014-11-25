package com.tdedu.bu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class CheckIntercepotor extends HandlerInterceptorAdapter {

	  private static final String[] IGNORE_URI = {"/login.jsp", "/Login/","kaptcha","captcha"};
	  
	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        boolean flag = false;
	        String url = request.getRequestURL().toString();
	        System.out.println(">>>"+url);
	        for (String s : IGNORE_URI) {
	            if (url.contains(s)) {
	                flag = true;
	                break;
	            }
	        }
	        if (!flag) {
	           HttpSession session =request.getSession();
	           Object check=session.getAttribute("managerName");
	            if (check != null) flag = true;
	        }
	        return flag;
	    }
	 
	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        super.postHandle(request, response, handler, modelAndView);
	    }

}

package com.ysdlb.spring.filter.filter;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// @WebFilter
// 通过FilterConfigure配置Bean，这里的WebFilter就不需要了
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("========================FirstFilter Init============================================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        System.out.println("========================FirstFilter===========================");
        System.out.println("Methods " + request.getMethod());
        System.out.println("URI: " + request.getRequestURI());
        System.out.println("URL: " + request.getRequestURL());
        System.out.println("Pram: " + JSON.toJSONString(request.getParameterMap()));
        System.out.println("respose: " + response.getStatus());
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("========================FirstFilter Destroy=========================================");
    }
}

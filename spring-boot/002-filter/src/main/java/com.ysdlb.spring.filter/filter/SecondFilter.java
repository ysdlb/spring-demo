package com.ysdlb.spring.filter.filter;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

// @WebFilter
// 通过FilterConfigure配置Bean，这里的WebFilter就不需要了
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("========================SecondFilter Init============================================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println("========================SecondFilter===========================");
        System.out.println("Methods " + request.getMethod());
        System.out.println("URI: " + request.getRequestURI());
        System.out.println("URL: " + request.getRequestURL());
        System.out.println("Pram: " + JSON.toJSONString(request.getParameterMap()));
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("========================SecondFilter Destroy=========================================");
    }
}

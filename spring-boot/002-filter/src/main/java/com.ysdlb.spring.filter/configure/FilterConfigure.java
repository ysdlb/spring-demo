package com.ysdlb.spring.filter.configure;

import com.ysdlb.spring.filter.filter.FirstFilter;
import com.ysdlb.spring.filter.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class FilterConfigure {
    @Bean
    public FilterRegistrationBean firstFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new FirstFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(10);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean secondFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SecondFilter());
        filterRegistrationBean.addUrlPatterns("/show");
        filterRegistrationBean.setOrder(11);
        return filterRegistrationBean;
    }
}

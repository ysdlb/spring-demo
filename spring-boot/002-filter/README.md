# 过滤器Filter的使用与注册
## 使用
实现Filter接口即可
## 注册
### 方法一
在Filter实现类上添加`@WebFilter`注解，且在项目启动入口类（***Application）
前添加`@ServletComponentScan`注解.
### 方法二
将实例化的Filter对象作为组件来配置一个FilterRegistrationBean实例，该方式的控制粒度更精细，可以设置Filter的优先级。
```java
@Configuration
public class FilterConfigure {
    @Bean
    public FilterRegistrationBean myFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.addUrlPatterns("pattern");
        filterRegistrationBean.setOrder(order_int);
        return filterRegistrationBean;
    }
}
```
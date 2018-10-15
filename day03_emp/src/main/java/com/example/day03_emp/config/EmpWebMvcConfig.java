package com.example.day03_emp.config;

import com.example.day03_emp.component.AuthInterceptor;
import com.example.day03_emp.component.I18n;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration //继承WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
public class EmpWebMvcConfig extends WebMvcConfigurerAdapter {

    /*
    相当于配置<mvc:view-controller path="/" view-name="home"/>
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("login");
    }
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/index.htm").setViewName("login");
                registry.addViewController("/main").setViewName("main");
            }
        };
        return  adapter;
    }
    @Bean //这种方式注入拦截器则拦截器中可以使用spring的ioc功能来注入其他bean
    public AuthInterceptor authInterceptor(){
        return  new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                //.addInterceptor(new AuthInterceptor())
                .addInterceptor(authInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/index.html","/index.htm","/login");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return  new I18n();
    }
}

package com.example.day03_emp.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/*
覆盖
org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter.localeResolver
通过请求头Accept-Language判断的方法，改为可以通过点击切换.
每一个请求都会进入到resolveLocale方法
 */
public class I18n  implements LocaleResolver{
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("lang");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}

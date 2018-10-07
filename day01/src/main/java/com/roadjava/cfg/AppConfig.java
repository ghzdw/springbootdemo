package com.roadjava.cfg;

import com.roadjava.service.GradeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 应用总的配置类
 * @Import作用：
 * 1.当Cfg1未被spring管理时，相当于xml中的bean标签
 * 2.当Cfg1被spring管理时，相当于xml中的import标签
 * @ImportResource作用：
 * 用于导入xml配置，属于由xml到注解的升级过渡,不推荐使用xml配置bean，而是通过@Bean
 * 来配置bean
 */
@Import({Cfg1.class,NonGlobleCfg.class}) @Configuration
@ImportResource(locations = {"classpath:beans.xml"})
public class AppConfig {
    @Bean //相当于xml中 的bean标签，生成一个bean，id为方法名
    public GradeService gradeService(){
        return  new GradeService();
    }
}

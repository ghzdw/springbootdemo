package com.roadjava;

import com.roadjava.cfg.AppConfig;
import com.roadjava.cfg.Cfg1;
import com.roadjava.cfg.NonGlobleCfg;
import com.roadjava.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {

        ConfigurableApplicationContext ac= SpringApplication.run(App.class,args);
        AppConfig appConfig= ac.getBean(AppConfig.class);
        //com.roadjava.cfg.AppConfig$$EnhancerBySpringCGLIB$$8b773f51@a53bb6f
        System.out.println(appConfig);

        Cfg1 cfg1= ac.getBean(Cfg1.class);
        /*
Cfg1{name='zhao
 daowen', name2='乐之者java', age=20, map1={k1=v1, k2=v2}, map2={k3=v3, k4=v4}, list1=[list1_a1, list1_a2, list1_a3], list2=[list2_1, list2_2]}
         */
        System.out.println(cfg1);

        NonGlobleCfg nonGlobleCfg= ac.getBean(NonGlobleCfg.class);
        /*
        NonGlobleCfg{name='zhao', maps={k2=v2, k1=v1}, lists=[1, 2, a]}
         */
        System.out.println(nonGlobleCfg);

        System.out.println("获取xml中配置的bean");
        UserService userService = ac.getBean(UserService.class);
        System.out.println(userService);
        System.out.println("获取@Bean配置的bean");
        Object gradeService = ac.getBean("gradeService");
        System.out.println(gradeService);
    }
}

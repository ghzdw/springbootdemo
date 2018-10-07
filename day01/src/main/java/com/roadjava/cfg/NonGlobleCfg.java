package com.roadjava.cfg;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;
/*
@PropertySource作用:
加载非全局配置文件里面的配置到配置类里面.跟@ConfigurationProperties一样，
可以加载map，list，对象这种复杂类型.注：需要结合@ConfigurationProperties指定
前缀
 */
@Configuration
@PropertySource({"classpath:nongloblecfg.properties"})
@ConfigurationProperties(prefix = "non")
public class NonGlobleCfg {
    private String name;
    private Map<String,Object> maps;
    private List<Object> lists;

    @Override
    public String toString() {
        return "NonGlobleCfg{" +
                "name='" + name + '\'' +
                ", maps=" + maps +
                ", lists=" + lists +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }
}

package com.roadjava.cfg;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties作用：
 * 让Cfg1与application.yml全局配置文件绑定起来，从配置文件里面获取值
 */
@ConfigurationProperties(prefix = "cfg1")
public class Cfg1 {
    private String name;
    private  String name2;
    private int age;
    private Map<String,Object> map1;
    private Map<String,Object> map2;
    private List<Object> list1;
    private List<Object> list2;

    @Override
    public String toString() {
        return "Cfg1{" +
                "name='" + name + '\'' +
                ", name2='" + name2 + '\'' +
                ", age=" + age +
                ", map1=" + map1 +
                ", map2=" + map2 +
                ", list1=" + list1 +
                ", list2=" + list2 +
                '}';
    }

    public Map<String, Object> getMap2() {
        return map2;
    }

    public void setMap2(Map<String, Object> map2) {
        this.map2 = map2;
    }

    public List<Object> getList2() {
        return list2;
    }

    public void setList2(List<Object> list2) {
        this.list2 = list2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Object> getMap1() {
        return map1;
    }

    public void setMap1(Map<String, Object> map1) {
        this.map1 = map1;
    }

    public List<Object> getList1() {
        return list1;
    }

    public void setList1(List<Object> list1) {
        this.list1 = list1;
    }

}

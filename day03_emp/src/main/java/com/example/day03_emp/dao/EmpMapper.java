package com.example.day03_emp.dao;

import java.util.List;
import java.util.Map;

//@Mapper结合@Select()等注解替代mapper.xml
public interface EmpMapper {
    Map<String,Object> login(Map<String,Object> paramMap);
    List<Map<String,Object>> getEmps();
    Integer addOneEmp(Map<String,Object> paramMap);
    Integer deleteEmpById(Integer id);
    Integer updateEmpById(Map<String,Object> paramMap);
    Map<String,Object> getEmpById(Integer id);
}

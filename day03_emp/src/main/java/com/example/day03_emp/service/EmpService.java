package com.example.day03_emp.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
    Map<String,Object> login(Map<String,Object> paramMap);
    List<Map<String,Object>> getEmps();
    Integer addOneEmp(Map<String,Object> paramMap);
    Integer deleteEmpById(Integer id);
    Integer updateEmpById(Map<String,Object> paramMap);
    Map<String,Object> getEmpById(Integer id);
}

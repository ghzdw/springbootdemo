package com.example.day03_emp.service.impl;

import com.example.day03_emp.dao.EmpMapper;
import com.example.day03_emp.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;
    @Override
    public Map<String, Object> login(Map<String, Object> paramMap) {
        return empMapper.login(paramMap);
    }

    @Override
    public List<Map<String, Object>> getEmps() {
        return empMapper.getEmps();
    }

    @Override
    public Integer addOneEmp(Map<String, Object> paramMap) {
        return empMapper.addOneEmp(paramMap);
    }

    @Override
    public Integer deleteEmpById(Integer id) {
        return empMapper.deleteEmpById(id);
    }

    @Override
    public Integer updateEmpById(Map<String, Object> paramMap) {
        return empMapper.updateEmpById(paramMap);
    }

    @Override
    public Map<String, Object> getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }
}

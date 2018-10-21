package com.example.day03_emp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//相当于xml中配置org.mybatis.spring.mapper.MapperScannerConfigurer的basePackage
@MapperScan(basePackages = {"com.example.day03_emp.dao"})
public class Day03EmpApplication {

	public static void main(String[] args) {
		System.out.println("day03_emp使用springboot完成雇员的crud");
		SpringApplication.run(Day03EmpApplication.class, args);
	}
}

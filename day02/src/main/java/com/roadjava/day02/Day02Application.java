package com.roadjava.day02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day02Application {
	private static Logger logger = LoggerFactory.getLogger(Day02Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Day02Application.class, args);
		/*
		springboot的日志：
		一、springboot默认是通过slf4j+logback的方式记录日志，可以在全局配置文件通过logging来配置
		二、也可以在类路径下放入所用日志框架自己的配置文件，如logback[-spring].xml,
		log4j2[-spring].xml，
		logging.properties
		不带-spring直接被所用日志框架识别，带-spring日志框架就不直接加载日志的配置项，而是由SpringBoot
		解析日志配置，可以使用SpringBoot的高级Profile（运行环境的配置,默认为default）功能。
		注意：配置了第二种第一种中的配置就不生效了
		 */
		logger.trace("trace日志信息");
		logger.debug("debug日志信息");
		logger.info("info日志信息");
		logger.warn("warn日志信息");
		logger.error("error日志信息");
	}
}

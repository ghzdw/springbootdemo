package springbootdemo.day04_emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day04EmpApplication {

	public static void main(String[] args) {
		System.out.println("缓存的实例");
		SpringApplication.run(Day04EmpApplication.class, args);
	}
}
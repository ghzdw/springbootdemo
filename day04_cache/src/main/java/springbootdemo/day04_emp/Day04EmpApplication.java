package springbootdemo.day04_emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day04EmpApplication {

	public static void main(String[] args) {
		System.out.println("day04_cache缓存的示例");
		System.out.println("缓存的示例");
		SpringApplication.run(Day04EmpApplication.class, args);
	}
}

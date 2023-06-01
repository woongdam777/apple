package edu.kh.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardProjectBootApplication { // Spring Boot Application을 만들고, 수행하는데 필요한 
											// 필수 어노테이션을 모아둔 어노테이션
	public static void main(String[] args) {
		SpringApplication.run(BoardProjectBootApplication.class, args);
	}

}

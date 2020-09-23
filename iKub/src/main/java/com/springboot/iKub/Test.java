package com.springboot.iKub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.springboot.iKub.repository")
@SpringBootApplication
public class Test {

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}
}

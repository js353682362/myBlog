package com.blog.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) {
		String s = "123";
		SpringApplication.run(SystemApplication.class, args);
	}
}

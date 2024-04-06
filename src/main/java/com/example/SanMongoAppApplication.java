package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.example.demo", "com.example.mongo" })
public class SanMongoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanMongoAppApplication.class, args);
	}

}

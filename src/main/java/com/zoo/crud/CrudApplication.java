package com.zoo.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.zoo.crud")
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}


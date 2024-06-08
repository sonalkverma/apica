package com.apica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableSwagger2
@ComponentScan(basePackages = "com.*")
@SpringBootApplication
public class ApicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicaApplication.class, args);
	}

}

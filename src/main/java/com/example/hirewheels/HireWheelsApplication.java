package com.example.hirewheels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HireWheelsApplication.class, args);

		ApplicationContext context = new AnnotationConfigApplicationContext();

		System.out.println("Running");
	}

}

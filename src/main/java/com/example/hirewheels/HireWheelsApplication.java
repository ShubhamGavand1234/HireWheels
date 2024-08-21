package com.example.hirewheels;

import com.example.hirewheels.entities.Role;
import com.example.hirewheels.entities.Users;
import com.example.hirewheels.services.InitService;
import com.example.hirewheels.services.UserService;
import org.apache.juli.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HireWheelsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(HireWheelsApplication.class, args);

//		ApplicationContext context = new AnnotationConfigApplicationContext();
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		System.out.println("Application Running");

		InitService initService = context.getBean(InitService.class);
		initService.start();


		UserService userService = context.getBean(UserService.class);
		Users LoginUser =  userService.getUser("admin@123", "upgrad@gmail.com1");
		if( LoginUser != null ) {
			System.out.println("LoggedInuser is " +  LoginUser.getFirstName() + " " + LoginUser.getLastName());
		}
		else {
			System.out.println("No user found please register");
		}

		Users shubham = new Users("Shubham", "Gavand", "password", "shubham@yahoo.in", "9011431755", 50000.00f, new Role(1,"Admin"));
		userService.createUser(shubham);



	}

}

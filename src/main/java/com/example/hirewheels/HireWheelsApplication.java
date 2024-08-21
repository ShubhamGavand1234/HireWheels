package com.example.hirewheels;

import com.example.hirewheels.entities.*;
import com.example.hirewheels.services.AdminService;
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

		Users mau = new Users("Mau", "Gavand", "meowpeow", "mewo@cat.com", "8888999977", 500.00f, new Role(2,"User"));
		userService.createUser(mau);

		AdminService adminService =  context.getBean(AdminService.class);
//		String vehicleModel, String vehicleNumber, String color, int availabilityStatus, String vehicleImageUrl, VehicleSubcategory
//		vehicleSubcategory, Location location, FuelType fuelType
		Vehicle dominar = new Vehicle("Bike", "MH062160", "Charcole", 1, "imge.com", new VehicleSubcategory(6,"SPORTS BIKE", 50 ,new VehicleCategory(2,"BIKE")),new Location(2,"Pen","Pen CHincpadad","402107",new City(1,"Mumbai")), new FuelType(1,"petrol") );

		Vehicle registerVehicle =   adminService.registerVehicle(dominar,mau);
		System.out.println(registerVehicle);



	}

}

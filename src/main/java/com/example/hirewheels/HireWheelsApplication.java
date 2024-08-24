package com.example.hirewheels;

import com.example.hirewheels.dao.FuelTypeDAO;
import com.example.hirewheels.dao.LocationDAO;
import com.example.hirewheels.dao.VehicleCategoryDAO;
import com.example.hirewheels.dao.VehicleSubcategoryDAO;
import com.example.hirewheels.entities.*;
import com.example.hirewheels.services.AdminService;
import com.example.hirewheels.services.BookingService;
import com.example.hirewheels.services.InitService;
import com.example.hirewheels.services.UserService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

@SpringBootApplication
public class HireWheelsApplication {




	public static void main(String[] args) {
//		SpringApplication.run(HireWheelsApplication.class, args);

//		ApplicationContext context = new AnnotationConfigApplicationContext();
		ApplicationContext context = SpringApplication.run(HireWheelsApplication.class, args);
		System.out.println("Application Running");

		InitService initService = context.getBean(InitService.class);
		initService.start();

		 VehicleSubcategoryDAO vehicleSubcategoryDAO = context.getBean(VehicleSubcategoryDAO.class);

		 LocationDAO locationDAO = context.getBean(LocationDAO.class);

		 FuelTypeDAO fuelTypeDAO = context.getBean(FuelTypeDAO.class) ;


		UserService userService = context.getBean(UserService.class);
		AdminService adminService = context.getBean(AdminService.class);
		BookingService bookingService = context.getBean(BookingService.class);

		Users shubham = new Users("Shubham", "Gavand", "password", "shubham@yahoo.in", "9011431755", 50000.00f, new Role(1,"Admin"));
		userService.createUser(shubham);

		Users mau = new Users("Mau", "Gavand", "meowpeow", "mewo@cat.com", "8888999977", 500.00f, new Role(2,"User"));
		userService.createUser(mau);

		Vehicle vehicle = new Vehicle("AMG", "IND 345", "Black", 1,
				"https://www.mercedes-amg.com/en/world-of-amg/news/press-information/mercedes-amg-gt-black-series-record-lap.html",
				vehicleSubcategoryDAO.findById(2).get(), locationDAO.findById(1).get(), fuelTypeDAO.findById(1).get());


		System.out.println(" regiser vehical = "  + adminService.registerVehicle(vehicle,shubham) );


		Booking myBooking = new Booking();
		myBooking.setUsers(shubham);
		myBooking.setBooking_date(new Date());
		myBooking.setDropoff_date(new Date());
		myBooking.setLocation(locationDAO.findById(1).get());
		myBooking.setAmount(200);
		myBooking.setPickup_date(new Date());
		myBooking.setVehicle(vehicle);

		adminService.changeAvailability(vehicle.getVehicle_id(), 0);

		bookingService.addBooking(myBooking);
	}

}

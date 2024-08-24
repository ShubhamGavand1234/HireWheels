package com.example.hirewheels.services;

import com.example.hirewheels.dao.BookingDAO;
import com.example.hirewheels.dao.UsersDAO;
import com.example.hirewheels.entities.Booking;
import com.example.hirewheels.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{


    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    UsersDAO usersDAO;

    @Override
    public Booking addBooking(Booking booking) {
       Users user = booking.getUsers();

       if(user.getWallet_money() < booking.getAmount()){
           System.out.println("Insufficient Balance , Please check with admin");

       }
       else {
           user.setWallet_money(user.getWallet_money() - booking.getAmount());
           usersDAO.save(user);
       }

       Booking saveBooking = bookingDAO.save(booking);
       return  saveBooking;
    }
}

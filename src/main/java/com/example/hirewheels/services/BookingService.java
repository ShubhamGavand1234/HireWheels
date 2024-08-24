package com.example.hirewheels.services;

import com.example.hirewheels.entities.Booking;
import com.example.hirewheels.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingService  {
    public Booking addBooking(Booking booking);
}

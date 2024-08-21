package com.example.hirewheels.dao;

import com.example.hirewheels.entities.Booking;
import com.example.hirewheels.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingDAO extends JpaRepository<com.example.hirewheels.entities.Booking, Integer> {
    List<Booking> findByVehicle(Vehicle vehicle);

}

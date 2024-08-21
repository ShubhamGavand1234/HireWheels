package com.example.hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDAO extends JpaRepository<com.example.hirewheels.entities.Booking, Integer> {
}

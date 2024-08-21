package com.example.hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Booking extends JpaRepository<com.example.hirewheels.entities.Booking, Integer> {
}

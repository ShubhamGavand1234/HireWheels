package com.example.hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDAO extends JpaRepository<com.example.hirewheels.entities.Vehicle, Integer> {
}

package com.example.hirewheels.dao;

import com.example.hirewheels.entities.VehicleSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategory extends JpaRepository<com.example.hirewheels.entities.VehicleCategory, Integer> {
}

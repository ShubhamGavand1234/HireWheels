package com.example.hirewheels.dao;

import com.example.hirewheels.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleCategoryDAO extends JpaRepository<com.example.hirewheels.entities.VehicleCategory, Integer> {

    VehicleCategory findByVehicleCategoryName(String category);
    VehicleCategory findByVehicleCategoryId(int categoryId);

}

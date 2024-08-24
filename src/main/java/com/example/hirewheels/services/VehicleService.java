package com.example.hirewheels.services;

import com.example.hirewheels.entities.Vehicle;

import java.util.Date;
import java.util.List;

public interface VehicleService {
    public List<Vehicle>  getAllVehicles();
    public List<Vehicle> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId);
}

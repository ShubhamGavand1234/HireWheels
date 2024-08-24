package com.example.hirewheels.services;

import com.example.hirewheels.entities.Users;
import com.example.hirewheels.entities.Vehicle;

public interface AdminService {

    public Vehicle registerVehicle(Vehicle vehicle, Users users);
    public Vehicle changeAvailability(int vehicleId, int availabilityStatus);

}

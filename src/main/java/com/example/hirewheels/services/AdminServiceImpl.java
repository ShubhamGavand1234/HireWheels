package com.example.hirewheels.services;

import com.example.hirewheels.dao.UsersDAO;
import com.example.hirewheels.dao.VehicleDAO;
import com.example.hirewheels.entities.Role;
import com.example.hirewheels.entities.Users;
import com.example.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    public VehicleDAO vehicleDAO;

    @Autowired
    private UsersDAO usersDAO;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle, Users users) {
        vehicle.setAvailability_status(1);

        Users loginUser = usersDAO.findByEmailAndPassword(users.getEmail(), users.getPassword()).get();
        Role loginRole =  loginUser.getRole();
        if(loginRole.getRole_name().equalsIgnoreCase("admin")){
            return vehicleDAO.save(vehicle);
        }
        return null;

    }
}

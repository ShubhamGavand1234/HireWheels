package com.example.hirewheels.services;

import com.example.hirewheels.dao.BookingDAO;
import com.example.hirewheels.dao.VehicleCategoryDAO;
import com.example.hirewheels.dao.VehicleDAO;
import com.example.hirewheels.entities.Booking;
import com.example.hirewheels.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    public VehicleDAO vehicleDAO;

    @Autowired
    VehicleCategoryDAO vehicleCategoryDao;

    @Autowired
    BookingDAO bookingDao;



    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> returnedVehicleList = vehicleDAO.findAll();
        return returnedVehicleList;
    }

    @Override
    public List<Vehicle> getAvailableVehicles(String categoryName, Date pickUpDate, Date dropDate, int locationId) {
        List<Vehicle> returnedVehicleList = new ArrayList<>();

        vehicleCategoryDao.findByVehicleCategoryName(categoryName).getVehicleSubcategories()
                .forEach(a -> a.getVehicles()
                        .forEach(b -> {
                            if(b.getLocation().getLocation_id() == locationId && b.getAvailability_status() == 1)
                                returnedVehicleList.add(b);
                        }));

        List<Integer> bookedVehicleIdList = new ArrayList<>();
        returnedVehicleList.forEach(a-> {
            List<Booking> bookedVehicleList = bookingDao.findByVehicle(a);
            bookedVehicleList.forEach(b ->{
                if ((pickUpDate.after(b.getPickup_date()) && pickUpDate.before(b.getDropoff_date()))
                        || (dropDate.after(b.getPickup_date()) && dropDate.before(b.getDropoff_date()))
                        || (pickUpDate.before(b.getPickup_date()) && dropDate.after(b.getDropoff_date()))
                        || pickUpDate.equals(b.getDropoff_date())
                        || dropDate.equals(b.getPickup_date())
                        || pickUpDate.equals(b.getPickup_date())
                        || dropDate.equals(b.getDropoff_date())){
                    bookedVehicleIdList.add(b.getVehicle().getVehicle_id());
                }
            });
        });
        List<Vehicle> availableVehicles = new ArrayList<>();
        returnedVehicleList.forEach(a-> {
            if(!bookedVehicleIdList.contains(a.getVehicle_id() )){
                availableVehicles.add(a);
            }
        });
        return availableVehicles;
    }


}

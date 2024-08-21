package com.example.hirewheels.entities;

import jakarta.persistence.*;

@Entity(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicle_id;

    @Column(name="vehicleModel", nullable = false)
    private String vehicle_model;

    @Column(name="vehicleNumber", nullable = false)
    private String vehicle_number;

    @Column(name="color", nullable = false, length = 50)
    private String color;

    @OneToOne
    @JoinColumn(name = "vehicle_subcategory_id")
    private VehicleSubcategory vehicleSubcategory;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne
    @JoinColumn(name = "fuel_type_id")
    private FuelType fuelType;

    @Column(name="availabilityStatus", nullable = false)
    private int availability_status;

    @Column(name="vehicleImageUrl", nullable = false, length = 500)
    private String vehicle_image_url;

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        this.vehicle_model = vehicle_model;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public VehicleSubcategory getVehicleSubcategory() {
        return vehicleSubcategory;
    }

    public void setVehicleSubcategory(VehicleSubcategory vehicleSubcategory) {
        this.vehicleSubcategory = vehicleSubcategory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getAvailability_status() {
        return availability_status;
    }

    public void setAvailability_status(int availability_status) {
        this.availability_status = availability_status;
    }

    public String getVehicle_image_url() {
        return vehicle_image_url;
    }

    public void setVehicle_image_url(String vehicle_image_url) {
        this.vehicle_image_url = vehicle_image_url;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", vehicle_number='" + vehicle_number + '\'' +
                ", color='" + color + '\'' +
                ", vehicleSubcategory=" + vehicleSubcategory +
                ", location=" + location +
                ", fuelType=" + fuelType +
                ", availability_status=" + availability_status +
                ", vehicle_image_url='" + vehicle_image_url + '\'' +
                '}';
    }
}

package com.example.hirewheels.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name="vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicle_id;

    @Column(name="vehicleModel", nullable = false)
    private String vehicle_model;

    @Column(name="vehicleNumber", nullable = false)
    private String vehicleNumber;

    @Column(name="color", nullable = false, length = 50)
    private String color;

    @ManyToOne
    @JoinColumn(name = "vehicle_subcategory_id")
    @JsonBackReference
    private VehicleSubcategory vehicleSubcategory;

    @ManyToOne
    @JoinColumn(name = "location_id")
    @JsonBackReference
    private Location location;

    @ManyToOne
    @JoinColumn(name = "fuel_type_id")
    @JsonBackReference
    private FuelType fuelType;

    @Column(name="availabilityStatus", nullable = false)
    private int availability_status;

    @Column(name="vehicleImageUrl", nullable = false, length = 500)
    private String vehicle_image_url;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Booking> bookings;

    public Vehicle() {

    }


    public Vehicle(String vehicleModel, String vehicleNumber, String color, int availabilityStatus, String vehicleImageUrl, VehicleSubcategory vehicleSubcategory, Location location, FuelType fuelType) {
        this.vehicle_model = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.availability_status = availabilityStatus;
        this.vehicle_image_url = vehicleImageUrl;
        this.vehicleSubcategory = vehicleSubcategory;
        this.location = location;
        this.fuelType = fuelType;
    }

    public Vehicle(int vehicleId, String vehicleModel, String vehicleNumber, String color, int availabilityStatus, String vehicleImageUrl, VehicleSubcategory vehicleSubcategory, Location location, FuelType fuelType) {
        this.vehicle_id = vehicleId;
        this.vehicle_model = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.availability_status = availabilityStatus;
        this.vehicle_image_url = vehicleImageUrl;
        this.vehicleSubcategory = vehicleSubcategory;
        this.location = location;
        this.fuelType = fuelType;
    }

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

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
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

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }



    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", vehicle_model='" + vehicle_model + '\'' +
                ", vehicle_number='" + vehicleNumber + '\'' +
                ", color='" + color + '\'' +
                ", vehicleSubcategory=" + vehicleSubcategory +
                ", location=" + location +
                ", fuelType=" + fuelType +
                ", availability_status=" + availability_status +
                ", vehicle_image_url='" + vehicle_image_url + '\'' +
                '}';
    }
}

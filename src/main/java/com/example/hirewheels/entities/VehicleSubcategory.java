package com.example.hirewheels.entities;

import jakarta.persistence.*;

@Entity(name="vehicle_subcategory")
public class VehicleSubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicle_subcategory_id;

    @Column(length = 50, nullable = false, unique = true)
    private String vehicle_subcategory_name;

    @Column( nullable = false)
    private double price_per_day;

    @OneToOne
    @JoinColumn(name = "vehicle_category_id")
    private VehicleCategory vehicleCategory;

    public int getVehicle_subcategory_id() {
        return vehicle_subcategory_id;
    }

    public void setVehicle_subcategory_id(int vehicle_subcategory_id) {
        this.vehicle_subcategory_id = vehicle_subcategory_id;
    }

    public String getVehicle_subcategory_name() {
        return vehicle_subcategory_name;
    }

    public void setVehicle_subcategory_name(String vehicle_subcategory_name) {
        this.vehicle_subcategory_name = vehicle_subcategory_name;
    }

    public double getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(double price_per_day) {
        this.price_per_day = price_per_day;
    }

    public com.example.hirewheels.entities.VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(com.example.hirewheels.entities.VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    @Override
    public String toString() {
        return "VehicleSubcategory{" +
                "vehicle_subcategory_id=" + vehicle_subcategory_id +
                ", vehicle_subcategory_name='" + vehicle_subcategory_name + '\'' +
                ", price_per_day=" + price_per_day +
                ", vehicleCategory=" + vehicleCategory +
                '}';
    }
}

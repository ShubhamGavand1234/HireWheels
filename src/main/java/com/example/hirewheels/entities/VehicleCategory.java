package com.example.hirewheels.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "vehicle_category")
public class VehicleCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleCategoryId;

    @Column(length = 50, nullable = false, unique = true)
    private String vehicleCategoryName;

    @OneToMany(mappedBy = "vehicleCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<VehicleSubcategory> vehicleSubcategories;

    public VehicleCategory() {
    }

    public VehicleCategory(int vehicleCategoryId, String vehicleCategoryName) {
        this.vehicleCategoryId = vehicleCategoryId;
        this.vehicleCategoryName = vehicleCategoryName;
    }

    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getVehicleCategoryName() {
        return vehicleCategoryName;
    }

    public void setVehicleCategoryName(String vehicleCategoryName) {
        this.vehicleCategoryName = vehicleCategoryName;
    }

    public Set<VehicleSubcategory> getVehicleSubcategories() {
        return vehicleSubcategories;
    }

    public void setVehicleSubcategories(Set<VehicleSubcategory> vehicleSubcategories) {
        this.vehicleSubcategories = vehicleSubcategories;
    }

    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicle_category_id=" + vehicleCategoryId +
                ", vehicle_category_name='" + vehicleCategoryName + '\'' +
                '}';
    }
}

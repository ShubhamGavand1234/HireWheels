package com.example.hirewheels.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name="fuel_type")
public class FuelType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fuel_type_id;

    @Column(length = 50, nullable = false)
    private String fuel_type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fuelType", cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    public FuelType() {
    }

    public FuelType(int fuelTypeId, String fuelType) {
        this.fuel_type_id = fuelTypeId;
        this.fuel_type = fuelType;
    }

    public int getFuel_type_id() {
        return fuel_type_id;
    }

    public void setFuel_type_id(int fuel_type_id) {
        this.fuel_type_id = fuel_type_id;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }



    @Override
    public String toString() {
        return "FuelType{" +
                "fuel_type_id=" + fuel_type_id +
                ", fuel_type='" + fuel_type + '\'' +
                '}';
    }
}

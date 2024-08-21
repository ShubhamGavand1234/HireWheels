package com.example.hirewheels.entities;

import jakarta.persistence.*;

@Entity(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int location_id;

    @Column(length = 50, nullable = false)
    private String location_name;

    @Column(length = 100, nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(nullable = false)
    private String pincode;

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "location_id=" + location_id +
                ", location_name='" + location_name + '\'' +
                ", address='" + address + '\'' +
                ", city=" + city +
                ", pincode='" + pincode + '\'' +
                '}';
    }
}

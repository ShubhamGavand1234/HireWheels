package com.example.hirewheels.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int location_id;

    @Column(length = 50, nullable = false)
    private String location_name;

    @Column(length = 100, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(nullable = false)
    private String pincode;

    @OneToMany(mappedBy = "location" , cascade = CascadeType.ALL)
    private Set<Booking> bookingsList;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

    public Location() {
    }

    public Location(int locationId, String locationName, String address, String pincode, City city) {
        this.location_id = locationId;
        this.location_name = locationName;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
    }

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

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Booking> getBookingsList() {
        return bookingsList;
    }

    public void setBookingsList(Set<Booking> bookingsList) {
        this.bookingsList = bookingsList;
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

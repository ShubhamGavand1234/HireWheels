package com.example.hirewheels.entities;

import jakarta.persistence.*;

@Entity(name="city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int city_id;

    @Column(length = 50, nullable = false)
    private String city_name;

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}

package com.example.hirewheels.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int booking_id;

    @Column(nullable = false)
    private LocalDateTime pickup_date;

    @Column(nullable = false)
    private LocalDateTime dropoff_date;

    @Column(nullable = false)
    private LocalDateTime booking_date;

    @Column(nullable = false)
    private double amount;

    @OneToOne
    @JoinColumn(name="location_id")
    private Location location;

    @OneToOne
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name="user_id")
    private Users users;

}

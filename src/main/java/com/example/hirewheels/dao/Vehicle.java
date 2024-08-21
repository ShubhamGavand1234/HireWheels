package com.example.hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Vehicle extends JpaRepository<com.example.hirewheels.entities.Vehicle, Integer> {
}

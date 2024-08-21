package com.example.hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDAO extends JpaRepository<com.example.hirewheels.entities.Location, Integer> {
}

package com.example.hirewheels.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDAO extends JpaRepository<com.example.hirewheels.entities.Users, Integer> {
}

package com.example.hirewheels.services;

import com.example.hirewheels.entities.Users;

public interface UserService {
    Users getUser(Users user);
    public Users createUser(Users user);
    public Users getUserDetailsByEmail(String email);
}

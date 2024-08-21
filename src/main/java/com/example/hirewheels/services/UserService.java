package com.example.hirewheels.services;

import com.example.hirewheels.entities.Users;

public interface UserService {
    public void createUser(Users user);
    public Users getUser(String password, String email);
}

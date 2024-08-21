package com.example.hirewheels.services;

import com.example.hirewheels.dao.UsersDAO;
import com.example.hirewheels.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UsersDAO usersDAO;

    @Override
    public void createUser(Users user) {
        usersDAO.save(user);
    }

    @Override
    public Users getUser(String password, String email) {
        System.out.println("Input credentials are ***** " + email + " " + password);

            if(!usersDAO.findByEmailIgnoreCase(email).isPresent()){
                System.out.println("User not Registered");
                return null;
            }
        Users storedUser = usersDAO.findByEmailIgnoreCase(email).get();

        System.out.println(storedUser);
            if( !storedUser.getPassword().equalsIgnoreCase(password) ){
                System.out.println("Unauthorized User");
                return null;
            }

        return storedUser;
    }



}

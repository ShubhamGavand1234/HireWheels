package com.example.hirewheels.services;

import com.example.hirewheels.dao.UsersDAO;
import com.example.hirewheels.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    public UsersDAO usersDAO;

    @Override
    public Users createUser(Users user) {
        boolean avalableUser = usersDAO.findByEmailIgnoreCase(user.getEmail()).isPresent();
        if(avalableUser){
            System.out.println("Email already exits");
        }
        boolean returendUser1 = usersDAO.findByMobileNoIgnoreCase(user.getMobileNo()).isPresent();
        if(returendUser1){
            System.out.println("Mobile number already exits");
        }
         return usersDAO.save(user);
    }

    @Override
    public Users getUser(Users user) {

            if(!usersDAO.findByEmailIgnoreCase(user.getEmail()).isPresent()){
                System.out.println("User not Registered");
                return null;
            }
        Users storedUser = usersDAO.findByEmailIgnoreCase(user.getEmail()).get();

        System.out.println(storedUser);
            if( !storedUser.getPassword().equalsIgnoreCase(user.getPassword()) ){
                System.out.println("Unauthorized User");
                return null;
            }

        return storedUser;
    }

    @Override
    public Users getUserDetailsByEmail(String email){
        boolean isPresent = usersDAO.findByEmailIgnoreCase(email).isPresent();
        if (isPresent){
            System.out.println("User not Registered");
        }
        Users retrivedUser = usersDAO.findByEmailIgnoreCase(email).get();
        return retrivedUser;
    }

}

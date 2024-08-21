package com.example.hirewheels.dao;

import com.example.hirewheels.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersDAO extends JpaRepository<com.example.hirewheels.entities.Users, Integer> {

    // Find user by first name (case-insensitive)
    List<Users> findByFirstNameIgnoreCase(String firstName);

    // Find user by first name or last name (case-insensitive)
    List<Users> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);

    // Find user by email (case-insensitive)
    Optional<Users> findByEmailIgnoreCase(String email);

    // Find user by mobile number (case-insensitive)
    Optional<Users> findByMobileNoIgnoreCase(String mobileNo);

    Optional<Users> findByEmailAndPassword(String email, String password);

//    public List<User> findByFirstNameIgnoreCase(String firstName);
//    public List<User> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);
//    public User findByMobileNoIgnoreCase(String mobileNo);
//    public User findByEmailIgnoreCase(String email);
//    public User findByEmailAndPassword(String email, String password);
//
//    @Query("SELECT u FROM Users u WHERE LOWER(u.firstName) = LOWER(:firstName)")
//    List<Users> findByFirstNameCustomQuery(@Param("firstName") String firstName);

}

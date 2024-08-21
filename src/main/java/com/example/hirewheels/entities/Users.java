package com.example.hirewheels.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity(name = "users")
@Check(constraints = "LENGTH(password) > 5")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(name="firstName", length = 50, nullable = false)
    private String first_name;

    @Column(name="lastName", length = 50)
    private String last_name;

//    @Size(min = 6)
    @Column(name="password", length = 50, nullable = false )
    private String password;

    @Column(name="email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name="mobileNo", nullable = false, unique = true)
    private String mobile_no;

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role_id;

    @Column(name="walletMoney", nullable = false)
    private double wallet_money = 10000.00;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public Role getRole() {
        return role_id;
    }

    public void setRole(Role role) {
        this.role_id = role;
    }

    public double getWallet_money() {
        return wallet_money;
    }

    public void setWallet_money(double wallet_money) {
        this.wallet_money = wallet_money;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                ", role_id=" + role_id +
                ", wallet_money=" + wallet_money +
                '}';
    }
}

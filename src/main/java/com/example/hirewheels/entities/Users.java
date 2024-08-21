package com.example.hirewheels.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.util.Set;

@Entity(name = "users")
@Check(constraints = "LENGTH(password) > 5")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column(name="firstName", length = 50, nullable = false)
    private String firstName;

    @Column(name="lastName", length = 50)
    private String lastName;

//    @Size(min = 6)
    @Column(name="password", length = 50, nullable = false )
    private String password;

    @Column(name="email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name="mobileNo", nullable = false, unique = true)
    private String mobileNo;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(name="walletMoney", nullable = false)
    private double wallet_money = 10000.00;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Booking> bookings;

    public Users() {
    }

    public Users(String firstName, String lastName, String password, String email, String mobileNo, float walletMoney, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.mobileNo = mobileNo;
        this.wallet_money = walletMoney;
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public double getWallet_money() {
        return wallet_money;
    }

    public void setWallet_money(double wallet_money) {
        this.wallet_money = wallet_money;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile_no='" + mobileNo + '\'' +
                ", walletMoney=" + wallet_money +
                ", role_id=" + role +
                '}';
    }
}

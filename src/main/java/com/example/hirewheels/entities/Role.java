package com.example.hirewheels.entities;

import jakarta.persistence.*;

@Entity(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    private int role_id;

    @Column(name="roleName", nullable = false, length = 50, unique = true)
    private String role_name;

    @OneToOne(mappedBy = "role")  // Reference to the Users entity
    private Users user;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}

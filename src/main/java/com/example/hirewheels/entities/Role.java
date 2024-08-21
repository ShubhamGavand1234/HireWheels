package com.example.hirewheels.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId")
    private int role_id;

    @Column(name="roleName", nullable = false, length = 50, unique = true)
    private String role_name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER, cascade = CascadeType.ALL)  // Reference to the Users entity
    private Set<Users> usersList;

    public Role() {
    }

    public Role(int roleId, String roleName) {
        this.role_id = roleId;
        this.role_name = roleName;
    }

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

    public Set<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(Set<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}

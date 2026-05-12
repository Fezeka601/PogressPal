package com.example.progresspal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Users {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "user_name")
    private String username;

    private String email;

    @Column(name = "password_hash")
    private String password;

    private LocalDateTime createdAt;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Integer getId() {
        return id;
    }
}

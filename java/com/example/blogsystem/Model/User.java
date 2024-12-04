package com.example.blogsystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull(message = "Username cannot be null")
    @Size(min = 5, message = "Username must be more than 4 characters")
    @Column(columnDefinition = "varchar(10) not null")
    private String username;

    @NotNull(message = "Password cannot be null")
    @Column(columnDefinition = "varchar(10) not null")
    private String password;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Column(columnDefinition = "varchar(50) not null")
    private String email;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(Integer userId, String username, String password, String email, LocalDate registration_date) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registrationDate = registration_date;
    }

    // Getter and Setter methods
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public LocalDate getRegistration_date() {
        return registrationDate;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registrationDate = registration_date;
    }

    // @PrePersist method to automatically set registration date if null
    @PrePersist
    public void prePersist() {
        if (this.registrationDate == null) {
            this.registrationDate = LocalDate.now(); // Sets current date if not set
        }
    }
}

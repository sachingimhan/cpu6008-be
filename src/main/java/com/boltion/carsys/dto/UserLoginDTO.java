package com.boltion.carsys.dto;

import lombok.*;

/**
 * @auther sachin
 * @date 2022-09-05
 */

@Data
public class UserLoginDTO {
    private String id;
    private String email;
    private String password;
    private String role;
    private CustomerDTO customer;
    private DriverDTO driver;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String id, String email, String password, String role, CustomerDTO customer, DriverDTO driver) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.customer = customer;
        this.driver = driver;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", customer=" + customer +
                ", driver=" + driver +
                '}';
    }
}

package com.boltion.carsys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    }
}

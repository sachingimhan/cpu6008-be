package com.boltion.carsys.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginDTO {
    private int id;
    private String email;
    private String password;
    private String role;
    private CustomerDTO customer;
    private DriverDTO driver;

    public UserLoginDTO(int id, String email, String password, String role, CustomerDTO customer) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.customer = customer;
    }
}

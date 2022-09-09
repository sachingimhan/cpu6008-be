package com.boltion.carsys.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserLogin {
    @Id
    private int id;
    private String email;
    private String password;
    private String role;
}

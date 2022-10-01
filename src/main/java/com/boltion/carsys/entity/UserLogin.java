package com.boltion.carsys.entity;

import lombok.*;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private String role;
}

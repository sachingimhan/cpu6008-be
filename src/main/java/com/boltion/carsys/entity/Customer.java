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
public class Customer {

    @Id
    private String nic;
    private String name;
    private String address;
    private String contact;
    private String drivingLicNo;
    @Column(name = "login_id")
    private int loginId;

}

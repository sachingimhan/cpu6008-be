package com.boltion.carsys.dto;

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
public class DriverDTO {
    private String nic;
    private String fullName;
    private String address;
    private String contact;
}

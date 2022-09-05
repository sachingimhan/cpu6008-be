package com.boltion.carsys.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
    private String nic;
    private String name;
    private String address;
    private String contact;
    private String drivingLicNo;
}

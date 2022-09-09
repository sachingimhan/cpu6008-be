package com.boltion.carsys.dto;

import lombok.*;

/**
 * @auther sachin
 * @date 2022-09-05
 */
@Data
public class CustomerDTO {
    private String nic;
    private String name;
    private String address;
    private String contact;
    private String drivingLicNo;

    public CustomerDTO(String nic, String name, String address, String contact, String drivingLicNo) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.drivingLicNo = drivingLicNo;
    }

    public CustomerDTO() {
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDrivingLicNo() {
        return drivingLicNo;
    }

    public void setDrivingLicNo(String drivingLicNo) {
        this.drivingLicNo = drivingLicNo;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", drivingLicNo='" + drivingLicNo + '\'' +
                '}';
    }
}

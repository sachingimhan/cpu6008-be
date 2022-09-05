package com.boltion.carsys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@Entity
public class Driver {
    @Id
    private String nic;
    private String fullName;
    private String address;
    private String contact;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rent> rentList;

    public Driver(String nic, String fullName, String address, String contact) {
        this.nic = nic;
        this.fullName = fullName;
        this.address = address;
        this.contact = contact;
    }

    public Driver() {
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "nic='" + nic + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", rentList=" + rentList +
                '}';
    }
}

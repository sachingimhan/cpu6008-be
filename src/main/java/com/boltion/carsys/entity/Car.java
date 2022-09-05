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
public class Car {
    @Id
    private String regNo;
    private String brand;
    private String type;
    private int passengerCount;
    private String color;
    private String transmissionType;
    private String fuelType;
    private double waiverAmount;
    private double dailyRate;
    private double monthlyRate;
    private double extraKmPrice;
    private double dailyFreeKm;
    private String states;
    private double monthlyFreeKm;
    private double drivenKm;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Rent> rentList;

    public Car(String regNo, String brand, String type, int passengerCount, String color, String transmissionType, String fuelType, double waiverAmount, double dailyRate, double monthlyRate, double extraKmPrice, double dailyFreeKm, String states, double monthlyFreeKm, double drivenKm) {
        this.regNo = regNo;
        this.brand = brand;
        this.type = type;
        this.passengerCount = passengerCount;
        this.color = color;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
        this.waiverAmount = waiverAmount;
        this.dailyRate = dailyRate;
        this.monthlyRate = monthlyRate;
        this.extraKmPrice = extraKmPrice;
        this.dailyFreeKm = dailyFreeKm;
        this.states = states;
        this.monthlyFreeKm = monthlyFreeKm;
        this.drivenKm = drivenKm;
    }
}

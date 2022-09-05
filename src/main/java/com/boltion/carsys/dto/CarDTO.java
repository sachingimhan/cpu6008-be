package com.boltion.carsys.dto;

import lombok.*;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@Data
public class CarDTO {
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
    private double monthlyFreeKm;
    private double drivenKm;
    private String states;

    public CarDTO() {
    }

    public CarDTO(String regNo, String brand, String type, int passengerCount, String color, String transmissionType, String fuelType, double waiverAmount, double dailyRate, double monthlyRate, double extraKmPrice, double dailyFreeKm, double monthlyFreeKm, double drivenKm, String states) {
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
        this.monthlyFreeKm = monthlyFreeKm;
        this.drivenKm = drivenKm;
        this.states = states;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getWaiverAmount() {
        return waiverAmount;
    }

    public void setWaiverAmount(double waiverAmount) {
        this.waiverAmount = waiverAmount;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getMonthlyRate() {
        return monthlyRate;
    }

    public void setMonthlyRate(double monthlyRate) {
        this.monthlyRate = monthlyRate;
    }

    public double getExtraKmPrice() {
        return extraKmPrice;
    }

    public void setExtraKmPrice(double extraKmPrice) {
        this.extraKmPrice = extraKmPrice;
    }

    public double getDailyFreeKm() {
        return dailyFreeKm;
    }

    public void setDailyFreeKm(double dailyFreeKm) {
        this.dailyFreeKm = dailyFreeKm;
    }

    public double getMonthlyFreeKm() {
        return monthlyFreeKm;
    }

    public void setMonthlyFreeKm(double monthlyFreeKm) {
        this.monthlyFreeKm = monthlyFreeKm;
    }

    public double getDrivenKm() {
        return drivenKm;
    }

    public void setDrivenKm(double drivenKm) {
        this.drivenKm = drivenKm;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "regNo='" + regNo + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", passengerCount=" + passengerCount +
                ", color='" + color + '\'' +
                ", transmissionType='" + transmissionType + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", waiverAmount=" + waiverAmount +
                ", dailyRate=" + dailyRate +
                ", monthlyRate=" + monthlyRate +
                ", extraKmPrice=" + extraKmPrice +
                ", dailyFreeKm=" + dailyFreeKm +
                ", monthlyFreeKm=" + monthlyFreeKm +
                ", drivenKm=" + drivenKm +
                ", states='" + states + '\'' +
                '}';
    }
}

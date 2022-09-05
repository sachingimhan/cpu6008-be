package com.boltion.carsys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@Data
public class RentDTO {

    private int reqId;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date palaceDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fromDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date toDate;
    private String pickUpNote;
    private String returnNote;
    private BigDecimal waiverAmount;
    private String state;
    private String reason;
    private CustomerDTO customer;
    private CarDTO car;
    private DriverDTO driver;

    public RentDTO(int reqId, Date palaceDate, Date fromDate, Date toDate, String pickUpNote, String returnNote, BigDecimal waiverAmount, String state, CustomerDTO customer, CarDTO car) {
        this.reqId = reqId;
        this.palaceDate = palaceDate;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.pickUpNote = pickUpNote;
        this.returnNote = returnNote;
        this.waiverAmount = waiverAmount;
        this.state = state;
        this.customer = customer;
        this.car = car;
    }

    public int getReqId() {
        return reqId;
    }

    public Date getPalaceDate() {
        return palaceDate;
    }

    public void setPalaceDate(Date palaceDate) {
        this.palaceDate = palaceDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getPickUpNote() {
        return pickUpNote;
    }

    public void setPickUpNote(String pickUpNote) {
        this.pickUpNote = pickUpNote;
    }

    public String getReturnNote() {
        return returnNote;
    }

    public void setReturnNote(String returnNote) {
        this.returnNote = returnNote;
    }

    public BigDecimal getWaiverAmount() {
        return waiverAmount;
    }

    public void setWaiverAmount(BigDecimal waiverAmount) {
        this.waiverAmount = waiverAmount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public CarDTO getCar() {
        return car;
    }

    public void setCar(CarDTO car) {
        this.car = car;
    }

    public DriverDTO getDriver() {
        return driver;
    }

    public void setDriver(DriverDTO driver) {
        this.driver = driver;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    @Override
    public String toString() {
        return "RentDTO{" +
                "reqId=" + reqId +
                ", palaceDate=" + palaceDate +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", pickUpNote='" + pickUpNote + '\'' +
                ", returnNote='" + returnNote + '\'' +
                ", waiverAmount=" + waiverAmount +
                ", state='" + state + '\'' +
                ", reason='" + reason + '\'' +
                ", customer=" + customer +
                ", car=" + car +
                ", driver=" + driver +
                '}';
    }
}

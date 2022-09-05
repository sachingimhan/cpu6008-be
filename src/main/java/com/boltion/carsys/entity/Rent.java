package com.boltion.carsys.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reqId;
    private Date palaceDate;
    private Date fromDate;
    private Date toDate;
    private String pickUpNote;
    private String returnNote;
    private BigDecimal waiverAmount;
    private String state;
    @Nullable
    @JsonIgnore
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CustNic", referencedColumnName = "nic", nullable = false)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RegNo", referencedColumnName = "regNo", nullable = false)
    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DrId", referencedColumnName = "nic", nullable = true)
    @JsonIgnore
    private Driver driver;

    @OneToOne(mappedBy = "rent", cascade = CascadeType.ALL)
    @JsonIgnore
    private CarReturn returnCar;


    public Rent(int reqId, Date palaceDate, Date fromDate, Date toDate, String pickUpNote, String returnNote, BigDecimal waiverAmount, String state, Customer customer, Car car) {
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

    public void setReqId(int reqId) {
        this.reqId = reqId;
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

    @Nullable
    public String getReason() {
        return reason;
    }

    public void setReason(@Nullable String reason) {
        this.reason = reason;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public CarReturn getReturnCar() {
        return returnCar;
    }

    public void setReturnCar(CarReturn returnCar) {
        this.returnCar = returnCar;
    }

    @Override
    public String toString() {
        return "Rent{" +
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
                ", returnCar=" + returnCar +
                '}';
    }
}

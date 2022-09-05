package com.boltion.carsys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
public class CarReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private Date returnDate;
    private BigDecimal drivenKm;
    @OneToOne
    @JoinColumn(name = "requestId", referencedColumnName = "reqId", nullable = false)
    @JsonIgnore
    private Rent rent;
    @OneToOne(mappedBy = "returnCar")
    @JsonIgnore
    private Payment payment;

    public CarReturn(int rid, Date returnDate, BigDecimal drivenKm, Rent rent) {
        this.rid = rid;
        this.returnDate = returnDate;
        this.drivenKm = drivenKm;
        this.rent = rent;
    }
}

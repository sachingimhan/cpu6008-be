package com.boltion.carsys.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CarReturnDTO {

    private int rid;
    private Date date;
    private BigDecimal drivenKm;
    private RentDTO rent;
    private PaymentDTO payment;

    public CarReturnDTO(int rid, Date date, BigDecimal drivenKm, RentDTO rent) {
        this.rid = rid;
        this.date = date;
        this.drivenKm = drivenKm;
        this.rent = rent;
    }
}

package com.boltion.carsys.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by Sahan Nimesha on 2022 - Sep
 * In IntelliJ IDEA
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payId;
    private Date payDate;
    private BigDecimal totalAmount;
    @OneToOne
    @JoinColumn(name = "rentId",referencedColumnName = "rid",nullable = false)
    private CarReturn returnCar;
    @OneToMany(mappedBy = "payment")
    private List<PaymentDetail> details;

    public Payment(int payId, Date payDate, BigDecimal totalAmount, CarReturn returnCar, List<PaymentDetail> details) {
        this.payId = payId;
        this.payDate = payDate;
        this.totalAmount = totalAmount;
        this.returnCar = returnCar;
        this.details = details;
    }
}

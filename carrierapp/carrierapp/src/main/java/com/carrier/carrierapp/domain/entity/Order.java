package com.carrier.carrierapp.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order extends  BaseEntity{

    @Column(nullable = false)
    private int orderDesi;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date orderDate;


    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal orderCarrierCost;

    // Foreign key ile Carrier ilişkisi
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrier_id", nullable = false)
    @JsonBackReference
    private Carrier carrier;


    public Order() {
    }
    public int getOrderDesi() {
        return orderDesi;
    }

    public void setOrderDesi(int orderDesi) {
        this.orderDesi = orderDesi;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderCarrierCost() {
        return orderCarrierCost;
    }

    public void setOrderCarrierCost(BigDecimal orderCarrierCost) {
        this.orderCarrierCost = orderCarrierCost;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }


}

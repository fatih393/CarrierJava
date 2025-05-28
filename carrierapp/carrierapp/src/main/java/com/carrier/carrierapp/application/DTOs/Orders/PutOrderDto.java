package com.carrier.carrierapp.application.DTOs.Orders;

import com.carrier.carrierapp.domain.entity.BaseEntity;

import java.math.BigDecimal;


public class PutOrderDto extends BaseEntity {

    private int orderDesi;
    private BigDecimal orderCarrierCost;
    private int CarrierId;

    public int getOrderDesi() {
        return orderDesi;
    }

    public void setOrderDesi(int orderDesi) {
        this.orderDesi = orderDesi;
    }

    public BigDecimal getOrderCarrierCost() {
        return orderCarrierCost;
    }

    public void setOrderCarrierCost(BigDecimal orderCarrierCost) {
        this.orderCarrierCost = orderCarrierCost;
    }

    public int getCarrierId() {
        return CarrierId;
    }

    public void setCarrierId(int carrierId) {
        CarrierId = carrierId;
    }
}

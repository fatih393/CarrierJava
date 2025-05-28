package com.carrier.carrierapp.application.DTOs.Orders;

import java.math.BigDecimal;
import java.util.Date;

public class PostOrderDto {
    private int orderDesi;
    private Date orderDate;
    private BigDecimal orderCarrierCost;
    private int CarrierId;

    public int getCarrierId() {
        return CarrierId;
    }

    public void setCarrierId(int carrierId) {
        CarrierId = carrierId;
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
}

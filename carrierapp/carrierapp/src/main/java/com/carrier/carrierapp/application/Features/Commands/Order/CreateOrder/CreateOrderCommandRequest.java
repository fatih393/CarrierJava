package com.carrier.carrierapp.application.Features.Commands.Order.CreateOrder;

import com.carrier.carrierapp.application.Features.Mediator.Request;

import java.math.BigDecimal;
import java.util.Date;

public class CreateOrderCommandRequest implements Request<CreateOrderCommandResponse> {
    private int orderDesi;
    private Date orderDate;
    private BigDecimal orderCarrierCost;
    private int CarrierId;

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

    public int getCarrierId() {
        return CarrierId;
    }

    public void setCarrierId(int carrierId) {
        CarrierId = carrierId;
    }
}

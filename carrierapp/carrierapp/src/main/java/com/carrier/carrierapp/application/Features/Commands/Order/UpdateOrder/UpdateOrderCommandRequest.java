package com.carrier.carrierapp.application.Features.Commands.Order.UpdateOrder;

import com.carrier.carrierapp.application.Features.Mediator.Request;

import java.math.BigDecimal;

public class UpdateOrderCommandRequest implements Request<UpdateOrderCommandResponse> {
    private int ID;
    private int orderDesi;
    private BigDecimal orderCarrierCost;
    private int CarrierId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

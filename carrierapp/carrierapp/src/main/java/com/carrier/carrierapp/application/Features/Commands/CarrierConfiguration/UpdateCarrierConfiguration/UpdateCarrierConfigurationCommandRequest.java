package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.UpdateCarrierConfiguration;

import com.carrier.carrierapp.application.Features.Mediator.Request;

import java.math.BigDecimal;

public class UpdateCarrierConfigurationCommandRequest implements Request<UpdateCarrierConfigurationCommandResponse> {
    private int ID;
    private int carrierMaxDesi;
    private int carrierMinDesi;
    private BigDecimal carrierCost;
    private int CarrierId;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCarrierMaxDesi() {
        return carrierMaxDesi;
    }

    public void setCarrierMaxDesi(int carrierMaxDesi) {
        this.carrierMaxDesi = carrierMaxDesi;
    }

    public int getCarrierMinDesi() {
        return carrierMinDesi;
    }

    public void setCarrierMinDesi(int carrierMinDesi) {
        this.carrierMinDesi = carrierMinDesi;
    }

    public BigDecimal getCarrierCost() {
        return carrierCost;
    }

    public void setCarrierCost(BigDecimal carrierCost) {
        this.carrierCost = carrierCost;
    }

    public int getCarrierId() {
        return CarrierId;
    }

    public void setCarrierId(int carrierId) {
        CarrierId = carrierId;
    }
}

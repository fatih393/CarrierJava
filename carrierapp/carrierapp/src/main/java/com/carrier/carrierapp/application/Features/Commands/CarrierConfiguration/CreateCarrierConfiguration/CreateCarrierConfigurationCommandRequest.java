package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.CreateCarrierConfiguration;

import com.carrier.carrierapp.application.Features.Mediator.Request;

import java.math.BigDecimal;

public class CreateCarrierConfigurationCommandRequest implements Request<CreateCarrierConfigurationCommandResponse> {
    private int CarrierId;
    private int carrierMaxDesi;
    private int carrierMinDesi;
    private BigDecimal carrierCost;

    public int getCarrierId() {
        return CarrierId;
    }

    public void setCarrierId(int carrierId) {
        CarrierId = carrierId;
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
}

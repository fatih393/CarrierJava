package com.carrier.carrierapp.application.DTOs.CarrierConfiguration;

import java.math.BigDecimal;

public class PostCarrierConfigurationDto {
    private int carrierMaxDesi;
    private int carrierMinDesi;
    private BigDecimal carrierCost;
    private int CarrierId;

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

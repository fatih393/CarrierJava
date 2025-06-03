package com.carrier.carrierapp.application.DTOs.Carriers;

import com.carrier.carrierapp.domain.entity.BaseEntity;

public class PutCarrierDto extends BaseEntity {

    private String carrierName;

    private boolean carriersActive;
    private int carrierPlusDesiCost;

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public boolean isCarriersActive() {
        return carriersActive;
    }

    public void setCarriersActive(boolean carriersActive) {
        this.carriersActive = carriersActive;
    }

    public int getCarrierPlusDesiCost() {
        return carrierPlusDesiCost;
    }

    public void setCarrierPlusDesiCost(int carrierPlusDesiCost) {
        this.carrierPlusDesiCost = carrierPlusDesiCost;
    }


}

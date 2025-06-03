package com.carrier.carrierapp.application.Features.Commands.Carrier.CreateCarrier;

import com.carrier.carrierapp.application.Features.Mediator.Request;

public class CreateCarrierCommandRequest implements Request<CreateCarrierCommandResponse> {

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

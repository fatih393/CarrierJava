package com.carrier.carrierapp.application.Features.Commands.Carrier.UpdateCarrier;

import com.carrier.carrierapp.application.Features.Mediator.Request;

public class UpdateCarrierCommandRequest implements Request<UpdateCarrierCommandResponse> {
   private int Id;



    private String carrierName;

    private boolean carriersActive;
    private int carrierPlusDesiCost;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

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

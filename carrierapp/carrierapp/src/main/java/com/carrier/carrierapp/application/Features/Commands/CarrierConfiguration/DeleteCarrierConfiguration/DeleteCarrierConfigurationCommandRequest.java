package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.DeleteCarrierConfiguration;

import com.carrier.carrierapp.application.Features.Mediator.Request;

public class DeleteCarrierConfigurationCommandRequest implements Request<DeleteCarrierConfigurationCommandResponse> {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

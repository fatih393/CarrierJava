package com.carrier.carrierapp.application.Features.Commands.Carrier.DeleteCarrier;

import com.carrier.carrierapp.application.Features.Mediator.Request;

public class DeleteCarrierCommandRequest implements Request<DeleteCarrierCommandResponse> {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

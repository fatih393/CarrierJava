package com.carrier.carrierapp.application.Features.Commands.Order.DeleteOrder;

import com.carrier.carrierapp.application.Features.Mediator.Request;

public class DeleteOrderCommandRequest implements Request<DeleteOrderCommandResponse> {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

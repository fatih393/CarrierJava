package com.carrier.carrierapp.application.Features.Commands.Order.UpdateOrder;

public class UpdateOrderCommandResponse {
    private String Message;

    public UpdateOrderCommandResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}

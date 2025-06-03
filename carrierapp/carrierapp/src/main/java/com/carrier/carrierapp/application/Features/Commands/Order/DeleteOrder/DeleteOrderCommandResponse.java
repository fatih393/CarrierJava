package com.carrier.carrierapp.application.Features.Commands.Order.DeleteOrder;

public class DeleteOrderCommandResponse {
    private String Message;

    public DeleteOrderCommandResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}

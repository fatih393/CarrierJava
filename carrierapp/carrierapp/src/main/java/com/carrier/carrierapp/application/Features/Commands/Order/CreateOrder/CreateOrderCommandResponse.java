package com.carrier.carrierapp.application.Features.Commands.Order.CreateOrder;

public class CreateOrderCommandResponse {
    private String Message;

    public CreateOrderCommandResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}

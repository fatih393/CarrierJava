package com.carrier.carrierapp.application.Features.Commands.Carrier.CreateCarrier;

public class CreateCarrierCommandResponse {
    private final  String Message;

    public CreateCarrierCommandResponse(String message) {
        Message = message;
    }
    public String getMessage() {
        return Message;
    }
}

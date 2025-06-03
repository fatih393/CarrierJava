package com.carrier.carrierapp.application.Features.Commands.Carrier.UpdateCarrier;

public class UpdateCarrierCommandResponse {
    private String Message;

    public UpdateCarrierCommandResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}

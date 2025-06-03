package com.carrier.carrierapp.application.Features.Commands.Carrier.DeleteCarrier;

public class DeleteCarrierCommandResponse {
    private String Message;

    public String getMessage() {
        return Message;
    }

    public DeleteCarrierCommandResponse(String message) {
        Message = message;
    }
}

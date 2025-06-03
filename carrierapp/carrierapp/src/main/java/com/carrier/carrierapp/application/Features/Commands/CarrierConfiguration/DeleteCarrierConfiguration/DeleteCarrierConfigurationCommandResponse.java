package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.DeleteCarrierConfiguration;

public class DeleteCarrierConfigurationCommandResponse {
    private String Message;

    public DeleteCarrierConfigurationCommandResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}

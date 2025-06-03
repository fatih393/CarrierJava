package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.CreateCarrierConfiguration;

public class CreateCarrierConfigurationCommandResponse {
    private String Message;

    public CreateCarrierConfigurationCommandResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}

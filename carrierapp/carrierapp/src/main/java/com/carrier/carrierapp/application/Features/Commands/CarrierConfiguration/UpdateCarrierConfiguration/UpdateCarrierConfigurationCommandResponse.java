package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.UpdateCarrierConfiguration;

public class UpdateCarrierConfigurationCommandResponse {
    private String Message;

    public UpdateCarrierConfigurationCommandResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}

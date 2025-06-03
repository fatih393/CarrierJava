package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.DeleteCarrierConfiguration;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierConfigurationService;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationWriteRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteCarrierConfigurationCommandHandler implements RequestHandler<DeleteCarrierConfigurationCommandRequest, DeleteCarrierConfigurationCommandResponse> {

private final ICarrierConfigurationService carrierConfigurationService;
    public DeleteCarrierConfigurationCommandHandler(ICarrierConfigurationService carrierConfigurationService) {

        this.carrierConfigurationService = carrierConfigurationService;
    }

    @Override
    public DeleteCarrierConfigurationCommandResponse handle(DeleteCarrierConfigurationCommandRequest request) {
      boolean control =  carrierConfigurationService.deleteCarrierConfiguration(request.getID());
      if (control)
          return new DeleteCarrierConfigurationCommandResponse("Silme başarılı");
      return new DeleteCarrierConfigurationCommandResponse("Silme başarısız");
    }
}

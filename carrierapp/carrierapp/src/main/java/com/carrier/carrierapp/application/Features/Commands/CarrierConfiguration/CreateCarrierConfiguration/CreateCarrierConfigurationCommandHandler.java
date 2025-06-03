package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.CreateCarrierConfiguration;

import com.carrier.carrierapp.application.Features.Mediator.Request;
import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierConfigurationService;
import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierReadRepository;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateCarrierConfigurationCommandHandler implements RequestHandler<CreateCarrierConfigurationCommandRequest, CreateCarrierConfigurationCommandResponse> {
private final ICarrierService carrierService;
private final ICarrierConfigurationService carrierConfigurationService;
    public CreateCarrierConfigurationCommandHandler(ICarrierService carrierService, ICarrierConfigurationService carrierConfigurationService) {

        this.carrierService = carrierService;
        this.carrierConfigurationService = carrierConfigurationService;
    }


    @Override
    public CreateCarrierConfigurationCommandResponse handle(CreateCarrierConfigurationCommandRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        CarrierConfiguration carrierConfigurationEntity = modelMapper.map(request, CarrierConfiguration.class);

        Carrier carrier = carrierService.getByIdCarrier(request.getCarrierId());


        carrierConfigurationEntity.setCarrier(carrier);
   carrierConfigurationEntity.setId(0);
        carrierConfigurationEntity.getCarrier();


         boolean control =   carrierConfigurationService.addCarrierConfiguration(carrierConfigurationEntity);
         if (control)
            return new CreateCarrierConfigurationCommandResponse("Konfigürasyon eklendi");
         return new CreateCarrierConfigurationCommandResponse("Konfigürasyon eklenirken bir hata oluştu");

    }
}

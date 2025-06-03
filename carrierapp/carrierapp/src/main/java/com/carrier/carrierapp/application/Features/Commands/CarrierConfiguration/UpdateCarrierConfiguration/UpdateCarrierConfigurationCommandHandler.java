package com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.UpdateCarrierConfiguration;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierConfigurationService;
import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierReadRepository;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationReadRepository;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateCarrierConfigurationCommandHandler implements RequestHandler<UpdateCarrierConfigurationCommandRequest, UpdateCarrierConfigurationCommandResponse> {

   private final ICarrierService carrierService;
   private final ICarrierConfigurationService carrierConfigurationService;

    public UpdateCarrierConfigurationCommandHandler(ICarrierService carrierService, ICarrierConfigurationService carrierConfigurationService) {

        this.carrierService = carrierService;
        this.carrierConfigurationService = carrierConfigurationService;
    }

    @Override
    public UpdateCarrierConfigurationCommandResponse handle(UpdateCarrierConfigurationCommandRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        CarrierConfiguration carrierConfigurationEntity = modelMapper.map(request, CarrierConfiguration.class);



        Carrier carrier =  carrierService.getByIdCarrier(request.getCarrierId());
        carrierConfigurationEntity.setCarrier(carrier);



        boolean control = carrierConfigurationService.updateCarrierConfiguration(carrierConfigurationEntity);
        if (control)
            return new UpdateCarrierConfigurationCommandResponse("Güncelleme başarılı");
        return new UpdateCarrierConfigurationCommandResponse("Güncelelme sırasında bir hata oluştu");
    }
}

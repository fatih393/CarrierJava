package com.carrier.carrierapp.application.Features.Commands.Carrier.UpdateCarrier;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdateCarrierCommandHandler implements RequestHandler<UpdateCarrierCommandRequest, UpdateCarrierCommandResponse> {

    private final ICarrierService carrierService;
    public UpdateCarrierCommandHandler(ICarrierService carrierService) {

        this.carrierService = carrierService;
    }

    @Override
    public UpdateCarrierCommandResponse handle(UpdateCarrierCommandRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        Carrier carrierEntity = modelMapper.map(request, Carrier.class);
        boolean control = carrierService.updateCarrier(carrierEntity);
        if (control)
            return new UpdateCarrierCommandResponse("Update is true");
        return new UpdateCarrierCommandResponse("update is false");
    }
}

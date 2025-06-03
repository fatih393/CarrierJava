package com.carrier.carrierapp.application.Features.Commands.Carrier.CreateCarrier;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.application.repositories.IWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCarrierCommandHandler  implements RequestHandler<CreateCarrierCommandRequest, CreateCarrierCommandResponse> {


    private final ICarrierService carrierService;
    @Autowired
    public CreateCarrierCommandHandler(ICarrierService carrierService) {
        this.carrierService = carrierService;
    }

    @Override
    public CreateCarrierCommandResponse handle(CreateCarrierCommandRequest request) {
        Carrier carrier = new Carrier(request.getCarrierName(), request.getCarrierPlusDesiCost(), request.isCarriersActive());
       boolean control =  carrierService.addCarrier(carrier);
        if (control)
            return new CreateCarrierCommandResponse("Carrier created successfully.");
        return  new CreateCarrierCommandResponse("Carrier not created successfully.");
    }
}

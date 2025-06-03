package com.carrier.carrierapp.application.Features.Commands.Carrier.DeleteCarrier;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierWriteRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteCarrierCommandHandler implements RequestHandler<DeleteCarrierCommandRequest, DeleteCarrierCommandResponse> {

    private final ICarrierService carrierService;
    public DeleteCarrierCommandHandler(ICarrierService carrierService) {

        this.carrierService = carrierService;
    }

    @Override
    public DeleteCarrierCommandResponse handle(DeleteCarrierCommandRequest request) {
        boolean control = carrierService.deleteCarrier(request.getID());
        if (control)
            return new DeleteCarrierCommandResponse("Delete is true");
        return new DeleteCarrierCommandResponse("Delete is false");
    }
}

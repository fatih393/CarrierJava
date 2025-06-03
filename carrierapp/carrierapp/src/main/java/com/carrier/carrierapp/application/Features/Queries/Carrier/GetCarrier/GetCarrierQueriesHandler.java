package com.carrier.carrierapp.application.Features.Queries.Carrier.GetCarrier;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.domain.entity.Carrier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCarrierQueriesHandler implements RequestHandler<GetCarrierQueriesRequest, GetCarrierQueriesResponse> {


private final ICarrierService carrierService;
    public GetCarrierQueriesHandler( ICarrierService carrierService) {

        this.carrierService = carrierService;
    }

    @Override
    public GetCarrierQueriesResponse handle(GetCarrierQueriesRequest request) {
        List<Carrier> carriers = carrierService.getAllCarriers();
        if (carriers != null)
            return  new GetCarrierQueriesResponse(carriers);
        return new GetCarrierQueriesResponse("Bir hata oluştu");
    }
}

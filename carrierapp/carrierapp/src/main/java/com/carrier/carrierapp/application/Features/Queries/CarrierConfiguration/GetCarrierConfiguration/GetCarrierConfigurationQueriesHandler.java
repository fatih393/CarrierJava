package com.carrier.carrierapp.application.Features.Queries.CarrierConfiguration.GetCarrierConfiguration;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.ICarrierConfigurationService;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationReadRepository;
import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCarrierConfigurationQueriesHandler implements RequestHandler<GetCarrierConfigurationQueriesRequest, GetCarrierConfigurationQueriesResponse> {
   private final ICarrierConfigurationService carrierConfigurationService;

    public GetCarrierConfigurationQueriesHandler(ICarrierConfigurationService carrierConfigurationService) {
        this.carrierConfigurationService = carrierConfigurationService;
    }


    @Override
    public GetCarrierConfigurationQueriesResponse handle(GetCarrierConfigurationQueriesRequest request) {
        return  new GetCarrierConfigurationQueriesResponse(carrierConfigurationService.getAllCarrierConfiguration());
    }
}

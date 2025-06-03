package com.carrier.carrierapp.application.Features.Queries.CarrierConfiguration.GetCarrierConfiguration;

import com.carrier.carrierapp.domain.entity.CarrierConfiguration;

import java.util.List;

public class GetCarrierConfigurationQueriesResponse {
    private final List<CarrierConfiguration> carrierConfigurationList;

    public List<CarrierConfiguration> getCarrierConfigurationList() {
        return carrierConfigurationList;
    }

    public GetCarrierConfigurationQueriesResponse(List<CarrierConfiguration> carrierConfigurationList) {
        this.carrierConfigurationList = carrierConfigurationList;
    }
}

package com.carrier.carrierapp.application.Features.Queries.Carrier.GetCarrier;

import com.carrier.carrierapp.domain.entity.Carrier;

import java.util.List;

public class GetCarrierQueriesResponse {
    private  List<Carrier> carriers;
    private String Message;

    public GetCarrierQueriesResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }

    public GetCarrierQueriesResponse(List<Carrier> carriers) {
        this.carriers = carriers;
    }
    public List<Carrier> getCarriers() {
        return carriers;
    }

}

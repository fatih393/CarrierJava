package com.carrier.carrierapp.application.Services;

import com.carrier.carrierapp.domain.entity.Carrier;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface ICarrierService {
    boolean addCarrier(Carrier carrier);

    boolean updateCarrier(Carrier updatedCarrier);

    boolean deleteCarrier(int id);
    Carrier getByIdCarrier(int id);

    List<Carrier> getAllCarriers();
}

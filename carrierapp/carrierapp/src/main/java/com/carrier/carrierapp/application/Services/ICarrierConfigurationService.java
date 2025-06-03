package com.carrier.carrierapp.application.Services;

import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import com.carrier.carrierapp.domain.entity.Order;

import java.util.List;

public interface ICarrierConfigurationService {
    boolean addCarrierConfiguration(CarrierConfiguration carrierConfiguration);
    boolean updateCarrierConfiguration(CarrierConfiguration carrierConfiguration);
    boolean deleteCarrierConfiguration(int id);
    List<CarrierConfiguration> getAllCarrierConfiguration();
    CarrierConfiguration getById(int id);
}

package com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrierconfiguration;

import com.carrier.carrierapp.Infrastructure.Persistence.repositories.ReadRepository;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationReadRepository;
import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import org.springframework.stereotype.Repository;

@Repository
public class CarrierConfigurationReadRepository  extends ReadRepository<CarrierConfiguration> implements ICarrierConfigurationReadRepository {
    public CarrierConfigurationReadRepository() {
        super(CarrierConfiguration.class);
    }
}

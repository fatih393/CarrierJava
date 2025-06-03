package com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrierconfiguration;

import com.carrier.carrierapp.Infrastructure.Persistence.repositories.ReadRepository;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationReadRepository;
import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CarrierConfigurationReadRepository  extends ReadRepository<CarrierConfiguration, Integer> implements ICarrierConfigurationReadRepository {
    public CarrierConfigurationReadRepository(EntityManager entityManager) {
        super(entityManager,CarrierConfiguration.class);
    }
}

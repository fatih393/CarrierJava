package com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrierconfiguration;


import com.carrier.carrierapp.Infrastructure.Persistence.repositories.WriteRepository;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationWriteRepository;
import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class CarrierConfigurationWriteRepository extends WriteRepository<CarrierConfiguration, Integer> implements ICarrierConfigurationWriteRepository {
    public CarrierConfigurationWriteRepository(EntityManager entityManager) {
        super(entityManager, CarrierConfiguration.class);
    }
}

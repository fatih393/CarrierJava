package com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier;

import com.carrier.carrierapp.Infrastructure.Persistence.repositories.WriteRepository;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CarrierWriteRepository extends WriteRepository<Carrier, Integer> implements ICarrierWriteRepository {
    @Autowired
    public CarrierWriteRepository(EntityManager entityManager) {
        super( entityManager, Carrier.class);
    }
}


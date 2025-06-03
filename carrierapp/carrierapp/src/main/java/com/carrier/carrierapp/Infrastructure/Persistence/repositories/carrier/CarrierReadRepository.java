package com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier;

import com.carrier.carrierapp.Infrastructure.Persistence.repositories.ReadRepository;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierReadRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class CarrierReadRepository extends ReadRepository<Carrier, Integer> implements ICarrierReadRepository {
    public CarrierReadRepository(EntityManager entityManager) {
        super(entityManager, Carrier.class);
    }
}

package com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier;

import com.carrier.carrierapp.Infrastructure.Persistence.repositories.ReadRepository;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierReadRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import org.springframework.stereotype.Repository;

@Repository
public class CarrierReadRepository extends ReadRepository<Carrier> implements ICarrierReadRepository {
    public CarrierReadRepository() {
        super(Carrier.class);
    }
}

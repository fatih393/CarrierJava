package com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier;

import com.carrier.carrierapp.Infrastructure.Persistence.repositories.WriteRepository;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import org.springframework.stereotype.Repository;

@Repository
public class CarrierWriteRepository extends WriteRepository<Carrier> implements ICarrierWriteRepository {


    public CarrierWriteRepository() {
        super(Carrier.class);
    }
}

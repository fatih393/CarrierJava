package com.carrier.carrierapp.Infrastructure.Persistence.Services;

import com.carrier.carrierapp.application.Services.ICarrierService;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierReadRepository;
import com.carrier.carrierapp.application.repositories.carrier.ICarrierWriteRepository;
import com.carrier.carrierapp.domain.entity.Carrier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarrierService implements ICarrierService {
    private final ICarrierReadRepository carrierReadRepository;
    private final ICarrierWriteRepository writeRepository;

    public CarrierService(ICarrierReadRepository carrierReadRepository, ICarrierWriteRepository writeRepository) {
        this.carrierReadRepository = carrierReadRepository;
        this.writeRepository = writeRepository;
    }

    @Override
    public boolean addCarrier(Carrier carrier) {
        try{
            writeRepository.save(carrier);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateCarrier(Carrier updatedCarrier) {
       return writeRepository.update(updatedCarrier);

    }

    @Override
    public boolean deleteCarrier(int id) {
       return writeRepository.deleteById(id);
    }

    @Override
    public List<Carrier> getAllCarriers() {
      return carrierReadRepository.findAll();
    }

    @Override
    public  Carrier getByIdCarrier(int id){
        Optional<Carrier> carrier = carrierReadRepository.findById(id);
        return carrier.get();
    }
}

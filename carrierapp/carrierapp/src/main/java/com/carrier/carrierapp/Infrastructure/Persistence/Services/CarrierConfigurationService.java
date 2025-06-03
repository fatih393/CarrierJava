package com.carrier.carrierapp.Infrastructure.Persistence.Services;

import com.carrier.carrierapp.application.Services.ICarrierConfigurationService;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationReadRepository;
import com.carrier.carrierapp.application.repositories.carrierconfiguration.ICarrierConfigurationWriteRepository;
import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CarrierConfigurationService implements ICarrierConfigurationService {
   private final ICarrierConfigurationWriteRepository writeRepository;
   private  final ICarrierConfigurationReadRepository readRepository;

    public CarrierConfigurationService(ICarrierConfigurationWriteRepository writeRepository, ICarrierConfigurationReadRepository readRepository) {
        this.writeRepository = writeRepository;
        this.readRepository = readRepository;
    }

    @Override
    public boolean addCarrierConfiguration(CarrierConfiguration carrierConfiguration) {
        try{
            writeRepository.save(carrierConfiguration);
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    @Override
    public boolean updateCarrierConfiguration(CarrierConfiguration carrierConfiguration) {
       return writeRepository.update(carrierConfiguration);
    }

    @Override
    public boolean deleteCarrierConfiguration(int id) {
       return writeRepository.deleteById(id);
    }

    @Override
    public List<CarrierConfiguration> getAllCarrierConfiguration() {
        return readRepository.findAll();
    }

    @Override
    public CarrierConfiguration getById(int id) {
        Optional<CarrierConfiguration> carrierConfiguration = readRepository.findById(id);
        return carrierConfiguration.get();
    }
}

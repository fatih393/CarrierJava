package com.carrier.carrierapp.application.controllers;


import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier.CarrierReadRepository;
import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrierconfiguration.CarrierConfigurationReadRepository;
import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrierconfiguration.CarrierConfigurationWriteRepository;
import com.carrier.carrierapp.application.DTOs.CarrierConfiguration.PostCarrierConfigurationDto;
import com.carrier.carrierapp.application.DTOs.CarrierConfiguration.PutCarrierConfigurationDto;
import com.carrier.carrierapp.domain.entity.Carrier;
import com.carrier.carrierapp.domain.entity.CarrierConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/carrierconfigurations")
public class CarrierConfigurationController  {
    private final CarrierConfigurationReadRepository configurationReadRepository;
    private final CarrierConfigurationWriteRepository configurationWriteRepository;
    private  final CarrierReadRepository carrierReadRepository;

    public CarrierConfigurationController(CarrierConfigurationReadRepository configurationReadRepository, CarrierConfigurationWriteRepository configurationWriteRepository, CarrierReadRepository carrierReadRepository) {
        this.configurationReadRepository = configurationReadRepository;
        this.configurationWriteRepository = configurationWriteRepository;
        this.carrierReadRepository = carrierReadRepository;
    }

    @PostMapping
    public CompletableFuture<?> CrateConfiguration(@RequestBody PostCarrierConfigurationDto postCarrierConfigurationDto){
        CarrierConfiguration configuration = new CarrierConfiguration();
        configuration.setCarrierCost(postCarrierConfigurationDto.getCarrierCost());
        configuration.setCarrierMaxDesi(postCarrierConfigurationDto.getCarrierMaxDesi());
        configuration.setCarrierMinDesi(postCarrierConfigurationDto.getCarrierMinDesi());

        Optional<Carrier> carrier = carrierReadRepository.getById(postCarrierConfigurationDto.getCarrierId());
        Carrier carrierEntity = carrier.get();
        configuration.setCarrier(carrierEntity);

        return configurationWriteRepository.addAsync(configuration)
                .thenApply(success -> {
                    if (success)
                        return ResponseEntity.ok(Map.of("status", "success"));
                    else
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }

    @GetMapping
    public List<CarrierConfiguration> getallCarrierConfigurations(){
        return configurationReadRepository.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarrierConfiguration(@PathVariable int id){
        boolean deleted = configurationWriteRepository.removeById(id);
        configurationWriteRepository.saveAsync();

        if (deleted)
            return ResponseEntity.ok("Carrier Configuration deleted successfully.");
        else
            return ResponseEntity.notFound().build();
    }

@PutMapping
    public ResponseEntity<String> updateCarrierConfiguration(@RequestBody PutCarrierConfigurationDto putCarrierConfigurationDto){
    if (putCarrierConfigurationDto == null)
        return ResponseEntity.badRequest().body("Invalid configuration data");

    Optional<CarrierConfiguration> optionalConfiguration = configurationReadRepository.getById(putCarrierConfigurationDto.getId());
    CarrierConfiguration configurationEntity = optionalConfiguration.get();

    configurationEntity.setId(putCarrierConfigurationDto.getId());
    configurationEntity.setCarrierCost(putCarrierConfigurationDto.getCarrierCost());
    configurationEntity.setCarrierMinDesi(putCarrierConfigurationDto.getCarrierMinDesi());
    configurationEntity.setCarrierMaxDesi(putCarrierConfigurationDto.getCarrierMaxDesi());

    Optional<Carrier> optionalCarrier = carrierReadRepository.getById(putCarrierConfigurationDto.getCarrierId());
    Carrier carrierEntity = optionalCarrier.get();

    if (carrierEntity == null) {
        throw new RuntimeException("Carrier not found with id: " + putCarrierConfigurationDto.getCarrierId());
    }
    configurationEntity.setCarrier(carrierEntity);

    boolean updated = configurationWriteRepository.update(configurationEntity);

    if (updated)
        return ResponseEntity.ok("Carrier Configuration updated successfully.");
    else
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to update Carrier Configuration.");


    }

}

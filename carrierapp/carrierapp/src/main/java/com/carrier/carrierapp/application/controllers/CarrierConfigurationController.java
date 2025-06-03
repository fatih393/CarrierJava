package com.carrier.carrierapp.application.controllers;


import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier.CarrierReadRepository;
import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrierconfiguration.CarrierConfigurationReadRepository;
import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrierconfiguration.CarrierConfigurationWriteRepository;
import com.carrier.carrierapp.application.DTOs.CarrierConfiguration.PostCarrierConfigurationDto;
import com.carrier.carrierapp.application.DTOs.CarrierConfiguration.PutCarrierConfigurationDto;
import com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.CreateCarrierConfiguration.CreateCarrierConfigurationCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.CreateCarrierConfiguration.CreateCarrierConfigurationCommandResponse;
import com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.DeleteCarrierConfiguration.DeleteCarrierConfigurationCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.DeleteCarrierConfiguration.DeleteCarrierConfigurationCommandResponse;
import com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.UpdateCarrierConfiguration.UpdateCarrierConfigurationCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.CarrierConfiguration.UpdateCarrierConfiguration.UpdateCarrierConfigurationCommandResponse;
import com.carrier.carrierapp.application.Features.Mediator.Mediator;
import com.carrier.carrierapp.application.Features.Queries.CarrierConfiguration.GetCarrierConfiguration.GetCarrierConfigurationQueriesRequest;
import com.carrier.carrierapp.application.Features.Queries.CarrierConfiguration.GetCarrierConfiguration.GetCarrierConfigurationQueriesResponse;
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
public class CarrierConfigurationController {

    private final CarrierConfigurationReadRepository configurationReadRepository;
    private final CarrierConfigurationWriteRepository configurationWriteRepository;
    private final CarrierReadRepository carrierReadRepository;
    private final Mediator mediator;

    public CarrierConfigurationController(CarrierConfigurationReadRepository configurationReadRepository,
                                          CarrierConfigurationWriteRepository configurationWriteRepository,
                                          CarrierReadRepository carrierReadRepository, Mediator mediator) {
        this.configurationReadRepository = configurationReadRepository;
        this.configurationWriteRepository = configurationWriteRepository;
        this.carrierReadRepository = carrierReadRepository;
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateCarrierConfigurationCommandResponse> createConfiguration(@RequestBody CreateCarrierConfigurationCommandRequest request) {
     /*   Optional<Carrier> carrierOpt = carrierReadRepository.findById(dto.getCarrierId());
        if (carrierOpt.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Carrier not found with id: " + dto.getCarrierId()));
        }

        CarrierConfiguration config = new CarrierConfiguration();
        config.setCarrierCost(dto.getCarrierCost());
        config.setCarrierMaxDesi(dto.getCarrierMaxDesi());
        config.setCarrierMinDesi(dto.getCarrierMinDesi());
        config.setCarrier(carrierOpt.get());

        CarrierConfiguration savedConfig = configurationWriteRepository.save(config);

        if (savedConfig != null) {
            return ResponseEntity.ok(Map.of("status", "success", "id", savedConfig.getId()));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }*/
        CreateCarrierConfigurationCommandResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetCarrierConfigurationQueriesResponse> getAllCarrierConfigurations(GetCarrierConfigurationQueriesRequest request) {
        GetCarrierConfigurationQueriesResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCarrierConfigurationCommandResponse> deleteCarrierConfiguration(@RequestBody DeleteCarrierConfigurationCommandRequest request) {
    /*    Optional<CarrierConfiguration> optionalConfig = configurationReadRepository.findById(id);
        if (optionalConfig.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrier Configuration not found.");
        }
        configurationWriteRepository.deleteById(id);
        return ResponseEntity.ok("Carrier Configuration deleted successfully.");*/
        DeleteCarrierConfigurationCommandResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    public ResponseEntity<UpdateCarrierConfigurationCommandResponse> updateCarrierConfiguration(@RequestBody UpdateCarrierConfigurationCommandRequest request) {
    /*    if (dto == null || dto.getId() != id) {
            return ResponseEntity.badRequest().body("Invalid configuration data");
        }

        Optional<CarrierConfiguration> configOpt = configurationReadRepository.findById(id);
        if (configOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carrier Configuration not found with id: " + id);
        }

        Optional<Carrier> carrierOpt = carrierReadRepository.findById(dto.getCarrierId());
        if (carrierOpt.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Carrier not found with id: " + dto.getCarrierId());
        }

        CarrierConfiguration config = configOpt.get();
        config.setCarrierCost(dto.getCarrierCost());
        config.setCarrierMinDesi(dto.getCarrierMinDesi());
        config.setCarrierMaxDesi(dto.getCarrierMaxDesi());
        config.setCarrier(carrierOpt.get());

        CarrierConfiguration saved = configurationWriteRepository.save(config);
        if (saved != null) {
            return ResponseEntity.ok("Carrier Configuration updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update Carrier Configuration.");
        }*/
        UpdateCarrierConfigurationCommandResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }
}


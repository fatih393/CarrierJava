package com.carrier.carrierapp.application.controllers;


import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier.CarrierReadRepository;
import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier.CarrierWriteRepository;
import com.carrier.carrierapp.application.DTOs.Carriers.PostCarrierDto;
import com.carrier.carrierapp.application.DTOs.Carriers.PutCarrierDto;
import com.carrier.carrierapp.application.Features.Commands.Carrier.CreateCarrier.CreateCarrierCommandHandler;
import com.carrier.carrierapp.application.Features.Commands.Carrier.CreateCarrier.CreateCarrierCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.Carrier.CreateCarrier.CreateCarrierCommandResponse;
import com.carrier.carrierapp.application.Features.Commands.Carrier.DeleteCarrier.DeleteCarrierCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.Carrier.DeleteCarrier.DeleteCarrierCommandResponse;
import com.carrier.carrierapp.application.Features.Commands.Carrier.UpdateCarrier.UpdateCarrierCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.Carrier.UpdateCarrier.UpdateCarrierCommandResponse;
import com.carrier.carrierapp.application.Features.Mediator.Mediator;
import com.carrier.carrierapp.application.Features.Queries.Carrier.GetCarrier.GetCarrierQueriesRequest;
import com.carrier.carrierapp.application.Features.Queries.Carrier.GetCarrier.GetCarrierQueriesResponse;
import com.carrier.carrierapp.domain.entity.Carrier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/carriers")
public class CarrierController {

    private final CarrierWriteRepository carrierWriteRepository;
    private final CarrierReadRepository carrierReadRepository;
    private final Mediator mediator;

    public CarrierController(CarrierWriteRepository carrierWriteRepository, CarrierReadRepository carrierReadRepository, Mediator mediator) {
        this.carrierWriteRepository = carrierWriteRepository;
        this.carrierReadRepository = carrierReadRepository;
        this.mediator = mediator;

    }

    @PostMapping
    public ResponseEntity<CreateCarrierCommandResponse> createCarrier(@RequestBody CreateCarrierCommandRequest request) {
      /*  Carrier carrier = new Carrier();
        carrier.setCarrierName(carrierDto.getCarrierName());
        carrier.setCarriersActive(carrierDto.isCarriersActive());
        carrier.setCarrierPlusDesiCost(carrierDto.getCarrierPlusDesiCost());

        Carrier savedCarrier = carrierWriteRepository.save(carrier);
        if (savedCarrier != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCarrier);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }*/
        CreateCarrierCommandResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetCarrierQueriesResponse> getAllCarriers(GetCarrierQueriesRequest request) {
        GetCarrierQueriesResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrier> getCarrierById(@PathVariable int id) {
        return carrierReadRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCarrierCommandResponse> updateCarrier(@RequestBody UpdateCarrierCommandRequest request) {
      /*  if (updatedCarrier == null || updatedCarrier.getId() != id) {
            return ResponseEntity.badRequest().body("Invalid carrier data");
        }

        Carrier carrierEntity = new Carrier();
        carrierEntity.setId(updatedCarrier.getId());
        carrierEntity.setCarrierName(updatedCarrier.getCarrierName());
        carrierEntity.setCarrierPlusDesiCost(updatedCarrier.getCarrierPlusDesiCost());
        carrierEntity.setCarriersActive(updatedCarrier.isCarriersActive());

        boolean updated = carrierWriteRepository.update(carrierEntity);

        if (updated) {
            return ResponseEntity.ok("Carrier updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update carrier.");
        }*/
        UpdateCarrierCommandResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCarrierCommandResponse> deleteCarrier(@RequestBody DeleteCarrierCommandRequest request) {
       DeleteCarrierCommandResponse response = mediator.send(request);
       return ResponseEntity.ok(response);
    }
}


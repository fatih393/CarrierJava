package com.carrier.carrierapp.application.controllers;


import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier.CarrierReadRepository;
import com.carrier.carrierapp.Infrastructure.Persistence.repositories.carrier.CarrierWriteRepository;
import com.carrier.carrierapp.application.DTOs.Carriers.PostCarrierDto;
import com.carrier.carrierapp.application.DTOs.Carriers.PutCarrierDto;
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
    public CarrierController(CarrierWriteRepository carrierWriteRepository, CarrierReadRepository carrierReadRepository) {
        this.carrierWriteRepository = carrierWriteRepository;
        this.carrierReadRepository = carrierReadRepository;
    }
    @PostMapping
    public CompletableFuture<ResponseEntity<Carrier>> createCarrier(@RequestBody PostCarrierDto carrierDto) {

        Carrier carrier = new Carrier();
        carrier.setCarrierName(carrierDto.getCarrierName());
        carrier.setCarriersActive(carrierDto.isCarriersActive());
        carrier.setCarrierPlusDesiCost(carrierDto.getCarrierPlusDesiCost());

        return carrierWriteRepository.addAsync(carrier)
                .thenApply(success -> {
                    if (success) {
                        return ResponseEntity.ok(carrier);
                    } else {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                });
    }

    @GetMapping
    public List<Carrier> getAllCarriers() {
        return carrierReadRepository.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarrier(@PathVariable int id) {
        boolean deleted = carrierWriteRepository.removeById(id);
        carrierWriteRepository.saveAsync();

        if (deleted) {
            return ResponseEntity.ok("Carrier deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCarrier(@PathVariable int id, @RequestBody PutCarrierDto updatedCarrier) {
        if (updatedCarrier == null || updatedCarrier.getId() != id) {
            return ResponseEntity.badRequest().body("Invalid carrier data");
        }

        // DTO'dan Entity'ye dönüşüm
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
        }
    }



}

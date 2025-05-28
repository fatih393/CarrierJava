package com.carrier.carrierapp.application.controllers;


import com.carrier.carrierapp.Infrastructure.Persistence.repositories.order.OrderReadRepository;
import com.carrier.carrierapp.Infrastructure.Persistence.repositories.order.OrderWriteRepository;
import com.carrier.carrierapp.application.DTOs.Orders.PostOrderDto;
import com.carrier.carrierapp.application.DTOs.Orders.PutOrderDto;
import com.carrier.carrierapp.domain.entity.Carrier;
import com.carrier.carrierapp.domain.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderReadRepository orderReadRepository;
    private final OrderWriteRepository orderWriteRepository;
private  final EntityManager entityManager;
    public OrderController(OrderReadRepository orderReadRepository, OrderWriteRepository orderWriteRepository, EntityManager entityManager) {
        this.orderReadRepository = orderReadRepository;
        this.orderWriteRepository = orderWriteRepository;
        this.entityManager = entityManager;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<Order>> CreateOrder(@RequestBody PostOrderDto postOrderDto){
        Order order = new Order();
        order.setOrderDesi(postOrderDto.getOrderDesi());
        order.setOrderDate(new Date());
        order.setOrderCarrierCost(postOrderDto.getOrderCarrierCost());

        Carrier carrier = entityManager.find(Carrier.class, postOrderDto.getCarrierId());
        if (carrier == null) {
            throw new RuntimeException("Carrier not found with id: " + postOrderDto.getCarrierId());
        }
        order.setCarrier(carrier);


        return orderWriteRepository.addAsync(order)
                .thenApply(success -> {
                    if (success)
                        return ResponseEntity.ok(order);
                    else
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                });
    }

    @GetMapping
    public List<Order> getallOrders(){
        return orderReadRepository.getAll();
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteOrder(@PathVariable int id){
        boolean deleted = orderWriteRepository.removeById(id);
        orderWriteRepository.saveAsync();

        if (deleted)
            return ResponseEntity.ok("Order deleted successfully.");
        else
            return ResponseEntity.notFound().build();

    }
    @PutMapping
    public ResponseEntity<String> updateOrder(@RequestBody PutOrderDto putOrderDto){
        if (putOrderDto == null)
            return ResponseEntity.badRequest().body("Invalid order data");

        Optional<Order> optionalOrder = orderReadRepository.getById(putOrderDto.getId());
        Order orderEntity = optionalOrder.get();

        orderEntity.setId(putOrderDto.getId());
        orderEntity.setOrderDesi(putOrderDto.getOrderDesi());
        orderEntity.setOrderDate(orderEntity.getOrderDate());
        orderEntity.setOrderCarrierCost(putOrderDto.getOrderCarrierCost());

        Carrier carrier = entityManager.find(Carrier.class, putOrderDto.getCarrierId());
        if (carrier == null) {
            throw new RuntimeException("Carrier not found with id: " + putOrderDto.getCarrierId());
        }
        orderEntity.setCarrier(carrier);

        boolean updated = orderWriteRepository.update(orderEntity);
        if (updated)
            return ResponseEntity.ok("Order updated successfully.");
         else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update order.");


    }

}

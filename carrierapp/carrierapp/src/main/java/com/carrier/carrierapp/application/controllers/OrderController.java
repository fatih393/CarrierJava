package com.carrier.carrierapp.application.controllers;


import com.carrier.carrierapp.Infrastructure.Persistence.repositories.order.OrderReadRepository;
import com.carrier.carrierapp.Infrastructure.Persistence.repositories.order.OrderWriteRepository;
import com.carrier.carrierapp.application.DTOs.Orders.PostOrderDto;
import com.carrier.carrierapp.application.DTOs.Orders.PutOrderDto;
import com.carrier.carrierapp.application.Features.Commands.Order.CreateOrder.CreateOrderCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.Order.CreateOrder.CreateOrderCommandResponse;
import com.carrier.carrierapp.application.Features.Commands.Order.DeleteOrder.DeleteOrderCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.Order.DeleteOrder.DeleteOrderCommandResponse;
import com.carrier.carrierapp.application.Features.Commands.Order.UpdateOrder.UpdateOrderCommandRequest;
import com.carrier.carrierapp.application.Features.Commands.Order.UpdateOrder.UpdateOrderCommandResponse;
import com.carrier.carrierapp.application.Features.Mediator.Mediator;
import com.carrier.carrierapp.application.Features.Queries.Order.GetOrder.GetOrderQueriesRequest;
import com.carrier.carrierapp.application.Features.Queries.Order.GetOrder.GetOrderQueriesResponse;
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
    private final EntityManager entityManager;
    private final Mediator mediator;

    public OrderController(OrderReadRepository orderReadRepository,
                           OrderWriteRepository orderWriteRepository,
                           EntityManager entityManager, Mediator mediator) {
        this.orderReadRepository = orderReadRepository;
        this.orderWriteRepository = orderWriteRepository;
        this.entityManager = entityManager;
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<CreateOrderCommandResponse> createOrder(@RequestBody CreateOrderCommandRequest request) {
      /*  Order order = new Order();
        order.setOrderDesi(postOrderDto.getOrderDesi());
        order.setOrderDate(new Date());
        order.setOrderCarrierCost(postOrderDto.getOrderCarrierCost());

        Carrier carrier = entityManager.find(Carrier.class, postOrderDto.getCarrierId());
        if (carrier == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
        order.setCarrier(carrier);

        Order savedOrder = orderWriteRepository.save(order);
        if (savedOrder != null) {
            return ResponseEntity.ok(savedOrder);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }*/
        CreateOrderCommandResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetOrderQueriesResponse> getAllOrders(GetOrderQueriesRequest request) {
        GetOrderQueriesResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrderCommandResponse> deleteOrder(@RequestBody DeleteOrderCommandRequest request) {
      /*  boolean exists = orderReadRepository.findById(id).isPresent();
        if (!exists) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }
        orderWriteRepository.deleteById(id);
        return ResponseEntity.ok("Order deleted successfully.");*/
        DeleteOrderCommandResponse response = mediator.send(request);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderCommandResponse> updateOrder(@RequestBody UpdateOrderCommandRequest request) {
      /*  if (putOrderDto == null || putOrderDto.getId() != id) {
            return ResponseEntity.badRequest().body("Invalid order data");
        }

        Optional<Order> optionalOrder = orderReadRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
        }

        Order orderEntity = optionalOrder.get();
        orderEntity.setOrderDesi(putOrderDto.getOrderDesi());
        // Tarihi genellikle güncelleme yapılmaz, eğer gerekiyorsa:
        // orderEntity.setOrderDate(putOrderDto.getOrderDate());
        orderEntity.setOrderCarrierCost(putOrderDto.getOrderCarrierCost());

        Carrier carrier = entityManager.find(Carrier.class, putOrderDto.getCarrierId());
        if (carrier == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Carrier not found.");
        }
        orderEntity.setCarrier(carrier);

        Order updatedOrder = orderWriteRepository.save(orderEntity);
        if (updatedOrder != null) {
            return ResponseEntity.ok("Order updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update order.");
        }*/
        UpdateOrderCommandResponse response = mediator.send(request);
        return ResponseEntity.ok(response);
    }
}


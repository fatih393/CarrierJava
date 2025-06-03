package com.carrier.carrierapp.Infrastructure.Persistence.repositories.order;

import com.carrier.carrierapp.Infrastructure.Persistence.repositories.WriteRepository;
import com.carrier.carrierapp.application.repositories.order.IOrderWriteRepository;
import com.carrier.carrierapp.domain.entity.Order;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class OrderWriteRepository extends WriteRepository<Order, Integer> implements IOrderWriteRepository {
    public OrderWriteRepository(EntityManager entityManager) {
        super(entityManager, Order.class);
    }
}

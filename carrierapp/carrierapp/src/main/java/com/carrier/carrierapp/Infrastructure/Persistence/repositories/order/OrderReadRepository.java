package com.carrier.carrierapp.Infrastructure.Persistence.repositories.order;

import com.carrier.carrierapp.Infrastructure.Persistence.repositories.ReadRepository;
import com.carrier.carrierapp.application.repositories.order.IOrderReadRepository;
import com.carrier.carrierapp.domain.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderReadRepository extends ReadRepository<Order> implements IOrderReadRepository {

    public OrderReadRepository() {
        super(Order.class);
    }
}

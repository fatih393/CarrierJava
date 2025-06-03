package com.carrier.carrierapp.application.Features.Queries.Order.GetOrder;

import com.carrier.carrierapp.domain.entity.Order;

import java.util.List;

public class GetOrderQueriesResponse {
    private final List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public GetOrderQueriesResponse(List<Order> orders) {
        this.orders = orders;
    }
}

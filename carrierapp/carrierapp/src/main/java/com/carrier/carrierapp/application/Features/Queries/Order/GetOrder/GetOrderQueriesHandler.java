package com.carrier.carrierapp.application.Features.Queries.Order.GetOrder;

import com.carrier.carrierapp.application.Features.Mediator.RequestHandler;
import com.carrier.carrierapp.application.Services.IOrderService;
import com.carrier.carrierapp.application.repositories.order.IOrderReadRepository;
import com.carrier.carrierapp.domain.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOrderQueriesHandler implements RequestHandler<GetOrderQueriesRequest, GetOrderQueriesResponse> {

    private final IOrderService orderService;
    public GetOrderQueriesHandler(IOrderService orderService) {

        this.orderService = orderService;
    }

    @Override
    public GetOrderQueriesResponse handle(GetOrderQueriesRequest request) {
        List<Order> orders = orderService.getAllOrder();
        return new GetOrderQueriesResponse(orders);
    }
}

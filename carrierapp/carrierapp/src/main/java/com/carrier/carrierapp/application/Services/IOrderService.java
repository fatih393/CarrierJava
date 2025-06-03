package com.carrier.carrierapp.application.Services;

import com.carrier.carrierapp.domain.entity.Order;

import java.util.List;

public interface IOrderService {
    boolean addOrder(Order order);
    boolean updateOrder(Order updateOrder);
    boolean deleteOrder(int id);
    List<Order> getAllOrder();
    Order getById(int id);
}

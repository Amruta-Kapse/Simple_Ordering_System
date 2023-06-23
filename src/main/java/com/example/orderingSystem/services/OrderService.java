package com.example.orderingSystem.services;

import java.util.List;
import java.util.Optional;

import com.example.orderingSystem.model.pojo.OrderDao;


public interface OrderService {
    public Optional<OrderDao> placeOrder(OrderDao order,Long customerId);

    public Optional<OrderDao> updateOrder(OrderDao order, Long orderId,Long customerId);

    public Optional<List<OrderDao>> getAllOrdersByCustomerId(Long customerId);

    public void cancelOrder(Long OrderId);

}

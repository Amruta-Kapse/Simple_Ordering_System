package com.example.orderingSystem.services;


import java.util.List;
import java.util.Optional;

import com.example.orderingSystem.mapper.CustomerMapper;
import com.example.orderingSystem.model.entity.CustomerEntity;
import com.example.orderingSystem.model.pojo.ItemDao;
import com.example.orderingSystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import com.example.orderingSystem.mapper.OrderMapper;
import com.example.orderingSystem.model.entity.OrderEntity;
import com.example.orderingSystem.model.pojo.OrderDao;
import com.example.orderingSystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepo;
    private final OrderMapper orderMapper;
    private final CustomerRepository customerRepo;
    private final CustomerMapper customerMapper;

    @Override
    public Optional<OrderDao> placeOrder(OrderDao order, Long customerId) {
        order.setOrderAmount(calculateDiscountPrice(order,customerId));
        OrderEntity orderEntity = orderMapper.mapOrderToOrderEntity(order);
        CustomerEntity customerEntity=customerRepo.findById(customerId).get();
        orderEntity.setCustomer(customerEntity);
        orderEntity = orderRepo.save(orderEntity);
        return Optional.ofNullable(orderMapper.mapOrderEntityToOrderDao(orderEntity));
    }

    @Override
    public Optional<OrderDao> updateOrder(OrderDao order, Long orderId, Long customerId) {
        OrderEntity orderEntity;
        if (orderRepo.existsById(orderId)) {
            orderEntity = orderRepo.findById(orderId).get();
            order.setOrderAmount(calculateDiscountPrice(order,customerId));
            orderMapper.mapOrderToOrderEntity(order);
            orderEntity.setId(orderId);
            orderRepo.save(orderEntity);
            return Optional.ofNullable(orderMapper.mapOrderEntityToOrderDao(orderEntity));
        }
        order.setOrderAmount(calculateDiscountPrice(order,customerId));
        orderEntity = orderMapper.mapOrderToOrderEntity(order);
        orderEntity = orderRepo.save(orderEntity);
        return Optional.ofNullable(orderMapper.mapOrderEntityToOrderDao(orderEntity));
    }

    @Override
    public Optional getAllOrdersByCustomerId(Long customerId) {
        orderRepo.findAllByCustomerId_Id(customerId);
        return Optional.ofNullable(orderRepo.findAllByCustomerId_Id(customerId));
    }

    @Override
    public void cancelOrder(Long OrderId) {
        OrderEntity orderEntity = orderRepo.findById(OrderId).get();
        orderRepo.delete(orderEntity);
    }

    public Double calculateDiscountPrice(OrderDao order,Long customerId) {
        int orderCount = orderRepo.countAllByCustomerId_Id(customerId);
        List<ItemDao> items = order.getItems();
        double amount = items.stream().map(item -> item.getItem_Price()).reduce(0.0, (a, b) -> a + b).doubleValue();
        Double discount = 0.0;
        if (orderCount >= 10 && orderCount < 20) {
            discount = (amount * 10) / 100;
            return (amount - discount);
        } else if (orderCount >= 20) {
            discount = (amount * 20) / 100;
            return (amount - discount);
        }
        return amount;
    }
}

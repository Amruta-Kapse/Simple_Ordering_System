package com.example.orderingSystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.orderingSystem.Exception.OrderException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.orderingSystem.model.pojo.OrderDao;
import com.example.orderingSystem.services.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<OrderDao> placeOrder(@RequestBody @Valid OrderDao order) {
        return new ResponseEntity<>(orderService.placeOrder(order).get(), HttpStatusCode.valueOf(201));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderDao> updateOrder(@RequestBody @Valid OrderDao order, @PathVariable("id") Long orderId) {
        return new ResponseEntity<>(orderService.updateOrder(order, orderId).get(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getAllOrders/{id}")
    public Optional<List<OrderDao>> getAllOrdersById(@PathVariable("id") Long customerId) {
        Optional<List<OrderDao>> list = orderService.getAllOrdersByCustomerId(customerId);
        return Optional.of(list.orElseThrow(() -> new OrderException("Order list is empty.")));
    }

    @DeleteMapping("/cancelOrder/{id}")
    public ResponseEntity CencelOrder(@PathVariable("id") Long OrderId) {
        orderService.cancelOrder(OrderId);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
}

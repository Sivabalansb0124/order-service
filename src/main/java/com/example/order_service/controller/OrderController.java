package com.example.order_service.controller;

import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setStatus("pending");
        return repo.save(order);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable String id, @RequestParam String status) {
        Order order = repo.findById(id).orElseThrow();
        order.setStatus(status);
        return repo.save(order);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable int customerId) {
        return repo.findAll().stream()
                .filter(o -> o.getCustomerId() == customerId)
                .toList();
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return repo.findAll();
    }
}

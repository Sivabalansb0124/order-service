package com.example.order_service.service;

import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public Order createOrder(Order order) {
        order.setStatus("pending");
        return repo.save(order);
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public Optional<Order> getOrderById(String id) {
        return repo.findById(id);
    }

    public Order updateOrderStatus(String id, String status) {
        return repo.findById(id).map(order -> {
            order.setStatus(status);
            return repo.save(order);
        }).orElse(null);
    }

    public void deleteOrder(String id) {
        repo.deleteById(id);
    }
}

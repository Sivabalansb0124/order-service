package com.example.order_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    private String customerId;
    private List<String> productIds;
    private String status; // pending, canceled, dispatched, shipped, delivered

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public List<String> getProductIds() { return productIds; }
    public void setProductIds(List<String> productIds) { this.productIds = productIds; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

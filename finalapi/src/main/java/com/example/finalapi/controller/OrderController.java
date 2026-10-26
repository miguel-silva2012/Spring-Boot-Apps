package com.example.finalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalapi.model.Order;
import com.example.finalapi.service.Mainservice;

@RestController 
@RequestMapping("/orders") 
public class OrderController {
    @Autowired 
    private Mainservice mainservice;

    @GetMapping 
    public List<Order> getAllOrders() {
        return mainservice.listOrder();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        Order order = mainservice.searchOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping 
    public Order saveOrder(@RequestBody Order order) {
        return mainservice.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdertById(@PathVariable Long id) {
        mainservice.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }    
}

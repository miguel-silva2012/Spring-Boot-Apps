package com.example.finalapi.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.finalapi.repository.OrderRepo;
import com.example.finalapi.exceptions.IdException;

import lombok.AllArgsConstructor;

import com.example.finalapi.model.Order;

@Service
@AllArgsConstructor  
public class Mainservice {
    private final OrderRepo orderRepo;

    public List<Order> listOrder() {
        return orderRepo.findAll();
    }

    public Order searchOrderById(Long id) {
        return orderRepo.findById(id)
            .orElseThrow(() -> new IdException("Invalid id: " + id));
    }

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    public void deleteOrderById(Long id) {

        if (!orderRepo.existsById(id)) {
            throw new IdException("Invalid id: " + id);
        }

        orderRepo.deleteById(id);
    }
}

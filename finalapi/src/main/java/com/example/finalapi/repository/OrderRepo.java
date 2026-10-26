package com.example.finalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalapi.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
    
}

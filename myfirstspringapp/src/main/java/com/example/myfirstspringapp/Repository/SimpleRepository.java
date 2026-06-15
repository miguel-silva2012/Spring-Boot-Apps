package com.example.myfirstspringapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myfirstspringapp.Model.SimpleEntity;

public interface SimpleRepository extends JpaRepository<SimpleEntity, Integer> {
    
}

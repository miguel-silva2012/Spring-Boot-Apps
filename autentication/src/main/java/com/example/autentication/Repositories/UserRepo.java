package com.example.autentication.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.autentication.Models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    
}

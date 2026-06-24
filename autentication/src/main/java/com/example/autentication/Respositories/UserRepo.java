package com.example.autentication.Respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.autentication.Domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    
}

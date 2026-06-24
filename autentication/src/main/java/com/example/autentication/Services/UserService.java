package com.example.autentication.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.autentication.Models.User;
import com.example.autentication.Repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }
    
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}

package com.example.autentication.Services;

import org.springframework.stereotype.Service;

import com.example.autentication.Domain.User;
import com.example.autentication.Respositories.UserRepo;
import com.example.autentication.Services.Exceptions.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainService {
    private final UserRepo userRepo;

    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User getUserById(int id) {
        return userRepo.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }
}

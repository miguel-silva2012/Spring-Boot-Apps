package com.example.autentication.Services;

import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.autentication.Models.User;
import com.example.autentication.Repositories.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User saveUser(String name, String password, String email) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(email, name, encodedPassword);
        return userRepo.save(user);
    }
    
    public Optional<User> getUserByName(String name) {
        return userRepo.findByName(name);
    }
}

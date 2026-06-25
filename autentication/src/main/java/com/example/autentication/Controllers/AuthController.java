package com.example.autentication.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autentication.Models.User;
import com.example.autentication.Services.UserService;
import com.example.autentication.Services.Security.JwtUtil;

import lombok.RequiredArgsConstructor;

import java.util.Map;

import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        User user = userService.saveUser(request.get("name"), request.get("password"), request.get("email"));
        return ResponseEntity.ok(user);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        Optional<User> user = userService.getUserByName(request.get("name"));

        if (!(user.isPresent() && user.get().getPassword().equals(request.get("password")))) {
            return ResponseEntity.status(401).body("Invalid credentials");
        } 

        String token = JwtUtil.generateToken(user.get().getName());

        return ResponseEntity.ok(Map.of("token", token));
        
    }
    
}

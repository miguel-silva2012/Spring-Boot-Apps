package com.example.autentication.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autentication.Models.User;
import com.example.autentication.Services.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @PostMapping("/post")
    public User postMethodName(@RequestBody User entity) {
        return userService.saveUser(entity.getName(), entity.getPassword(), entity.getEmail());
    }
    
}

package com.example.autentication.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.autentication.Domain.User;
import com.example.autentication.Services.MainService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @GetMapping("/{id}")
    public User getMethodName(@PathVariable int id) {
        return mainService.getUserById(id);
    }

    @PostMapping("/users")
    public User postMethodName(@RequestBody User entity) {      
        return mainService.saveUser(entity);
    }
    
}

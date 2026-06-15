package com.example.myfirstspringapp.Service;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String getMensage() {
        return "Olá, mundo!";
    }
}

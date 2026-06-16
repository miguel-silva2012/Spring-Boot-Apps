package com.example.contact_app.Service.Exceptions;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String mensage) {
        super(mensage);
    }
}

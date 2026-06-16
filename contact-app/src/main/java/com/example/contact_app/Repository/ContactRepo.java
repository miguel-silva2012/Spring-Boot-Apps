package com.example.contact_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.contact_app.Models.Contact;

public interface ContactRepo extends JpaRepository<Contact, Integer> {
    
}

package com.example.contact_app.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.contact_app.Models.Contact;
import com.example.contact_app.Repository.ContactRepo;

import com.example.contact_app.Service.Exceptions.ContactNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepo contactRepo;

    public List<Contact> listContacts() {
        return this.contactRepo.findAll();
    }

    public Contact listContactById(int id) {
        return this.contactRepo.findById(id)
            .orElseThrow(() -> new ContactNotFoundException("The contact with id: " + id + " not found"));
    }

    public Contact saveContact(Contact contact) {
        return this.contactRepo.save(contact);
    }

    public void deleteContactByID(int id) {
        this.contactRepo.deleteById(id);
    }
}

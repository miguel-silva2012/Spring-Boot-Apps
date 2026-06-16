package com.example.contact_app.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.contact_app.Models.Contact;
import com.example.contact_app.Service.ContactService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/apicontact")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactseService) {
        this.contactService = contactseService;
    }

    @PostMapping
    public Contact postMethodName(@RequestBody Contact contact) {
        contactService.saveContact(contact);
        return contact;
    }

    @GetMapping
    public List<Contact> getMethodName() {
        return contactService.listContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMethodName(@PathVariable int id) {
        Contact contact = contactService.listContactById(id);
        return ResponseEntity.ok(contact);
    }
     
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMethodName(@PathVariable int id) {
        contactService.deleteContactByID(id);
        return ResponseEntity.ok(contactService.listContactById(id));
    }
}

package com.example.demo.Controller;

import com.example.demo.Entity.Contacts;
import com.example.demo.Services.ContactsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Contacts")
public class ContactsController {
    private final ContactsServices contactsServices;

    public ContactsController(ContactsServices contactsServices){
        this.contactsServices =contactsServices;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok().body(contactsServices.getAll());
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            Contacts contacts = contactsServices.getOne(id);
            return ResponseEntity.ok().body(contacts);
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        try{
            Contacts contacts = contactsServices.getOne(id);
            contactsServices.delete(id);
            return ResponseEntity.ok().body("Contacts with id = " + id + " deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Contacts> create (@Validated @RequestBody Contacts contacts) {
        Contacts savedContacts = contactsServices.create(contacts);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContacts);
    }
}

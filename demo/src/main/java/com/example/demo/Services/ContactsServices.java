package com.example.demo.Services;

import com.example.demo.Entity.Contacts;
import com.example.demo.Repository.ContactsRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServices {
    private final ContactsRepo contactsRepo;

    public ContactsServices (ContactsRepo contactsRepo){
        this.contactsRepo = contactsRepo ;
    }
    public List<Contacts> getAll(){
        return contactsRepo.findAll();
    }
    public Contacts getOne(Long id){

        return contactsRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("This Contacts with id = " + id + " is not exist"));
    }

    public Contacts create (Contacts contacts){
        try{
            return contactsRepo.save(contacts);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("This Contacts Already Exist");
        }
    }
    public void delete(Long id){
        contactsRepo.deleteById(id);
    }
    public Contacts update(Long id, Contacts contacts) {
        Contacts existingContact = contactsRepo.findById(id).orElse(null);
        if (existingContact == null) {
            throw new RuntimeException("Contact not found");
        }

        existingContact.setEmail(contacts.getEmail());
        existingContact.setPhone_number(contacts.getPhone_number());


        return contactsRepo.save(existingContact);
    }
}

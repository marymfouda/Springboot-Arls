package com.example.demo.Services;

import com.example.demo.Entity.Partners;
import com.example.demo.Repository.PartnersRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnersServices {
    private final PartnersRepo partnersRepo;

    public PartnersServices (PartnersRepo partnersRepo){
        this.partnersRepo = partnersRepo ;
    }
    public List<Partners> getAll(){
        return partnersRepo.findAll();
    }
    public Partners getOne(Long id){

        return partnersRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("This Partner with id = " + id + " is not exist"));
    }

    public Partners create (Partners partners){
        try{
            return partnersRepo.save(partners);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("This Partner Already Exist");
        }
    }
    public void delete(Long id){
        partnersRepo.deleteById(id);
    }

}

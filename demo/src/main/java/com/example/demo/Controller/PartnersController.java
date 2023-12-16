package com.example.demo.Controller;

import com.example.demo.Entity.Partners;
import com.example.demo.Services.PartnersServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Partner")
public class PartnersController {
    private final PartnersServices partnersServices;

    public PartnersController(PartnersServices partnersServices){
        this.partnersServices =partnersServices;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok().body(partnersServices.getAll());
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            Partners partners = partnersServices.getOne(id);
            return ResponseEntity.ok().body(partners);
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        try{
            Partners partners = partnersServices.getOne(id);
            partnersServices.delete(id);
            return ResponseEntity.ok().body("Partner with id = " + id + " deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Partners> create (@Validated @RequestBody Partners partners) {
        Partners savedArticles = partnersServices.create(partners);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticles);
    }
}

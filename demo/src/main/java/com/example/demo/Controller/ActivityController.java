package com.example.demo.Controller;


import com.example.demo.Entity.Activity;
import com.example.demo.Services.ActivityServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Activity")
public class ActivityController {
    private final ActivityServices activityServices;

    public ActivityController (ActivityServices activityServices){
        this.activityServices = activityServices;
    }
    @GetMapping
    public ResponseEntity<?> getAll (){
        try{
            return ResponseEntity.ok().body(activityServices.getAll());
        }catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            Activity activity = activityServices.getOne(id);
            return ResponseEntity.ok().body(activity);
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        try{
            Activity activity = activityServices.getOne(id);
            activityServices.delete(id);
            return ResponseEntity.ok().body("Activity with id = " + id + " deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Activity> create (@Validated @RequestBody Activity activity) {
        Activity savedActivity = activityServices.create(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedActivity);
    }
}

package com.example.demo.Controller;

import com.example.demo.Entity.Location;
import com.example.demo.Services.LocationServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Location")
public class LocationController {
    private final LocationServices locationServices;

    public LocationController(LocationServices locationServices){
        this.locationServices =locationServices;
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.ok().body(locationServices.getAll());
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try {
            Location location = locationServices.getOne(id);
            return ResponseEntity.ok().body(location);
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        try{
            Location location = locationServices.getOne(id);
            locationServices.delete(id);
            return ResponseEntity.ok().body("Location with id = " + id + " deleted Successfully");
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @PostMapping
    public ResponseEntity<Location> create (@Validated @RequestBody Location location) {
        Location savedLocation = locationServices.create(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
    }
}

package com.example.demo.Services;

import com.example.demo.Entity.Location;
import com.example.demo.Repository.LocationRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServices {
    private final LocationRepo locationRepo;

    public LocationServices (LocationRepo locationRepo){
        this.locationRepo = locationRepo ;
    }
    public List<Location> getAll(){
        return locationRepo.findAll();
    }
    public Location getOne(Long id){

        return locationRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("This Location with id = " + id + " is not exist"));
    }

    public Location create (Location location){
        try{
            return locationRepo.save(location);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("This Location Already Exist");
        }
    }
    public void delete(Long id){
        locationRepo.deleteById(id);
    }
    public Location update(Long id, Location location) {
        Location existingLocation = locationRepo.findById(id).orElse(null);
        if (existingLocation == null) {
            throw new RuntimeException("Location not found");
        }

        existingLocation.setTitle(location.getTitle());


        return locationRepo.save(existingLocation);
    }
}

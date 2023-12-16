package com.example.demo.Services;

import com.example.demo.Entity.Activity;
import com.example.demo.Repository.ActivityRepo;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServices {
    private final ActivityRepo activityRepo;

    public ActivityServices (ActivityRepo activityRepo){
        this.activityRepo = activityRepo ;
    }
    public List<Activity> getAll(){
        return activityRepo.findAll();
    }
    public Activity getOne(Long id){

        return activityRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("This Activity with id = " + id + " is not exist"));
    }

    public Activity create (Activity activity){
        try{
            return activityRepo.save(activity);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("This Activity Already Exist");
        }
    }
    public void delete(Long id){
        activityRepo.deleteById(id);
    }
    public Activity update(Long id, Activity activity) {
        Activity existingActivity = activityRepo.findById(id).orElse(null);
        if (existingActivity == null) {
            throw new RuntimeException("Activity not found");
        }

        existingActivity.setText(activity.getText());


        return activityRepo.save(existingActivity);
    }
}

package com.skillstorm.project4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.models.Goal;
import com.skillstorm.project4.services.GoalService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = { "/goals/v1" })
public class GoalController {
    @Autowired
    public GoalService goalService;
    
    @GetMapping
    public List<Goal> fetchGoals() {
    	return null;
    }
}

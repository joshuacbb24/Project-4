package com.skillstorm.project4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.dtos.GoalDto;
import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.models.CustomUserDetails;
import com.skillstorm.project4.models.Goal;
import com.skillstorm.project4.services.GoalService;

@RestController
//@CrossOrigin(allowCredentials = "true", origins = {"http://localhost:8000", "http://localhost:4200"}, allowedHeaders = "*")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/home/v1")
public class GoalController {
	
    @Autowired
    public GoalService goalService;
    
    /*
    @GetMapping
    public List<Goal> fetchGoals() {
    	return null;
    }
    */
    @GetMapping
    public ResponseEntity<List<Goal>> fetchGoals(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
    	List<Goal> goals = goalService.fetchGoals(customUserDetails);
    	return new ResponseEntity<>(goals, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Goal> fetchGoal(@AuthenticationPrincipal CustomUserDetails customUserDetails, @PathVariable int id){
    	Goal goal = goalService.fetchGoal(id);
    	return new ResponseEntity<Goal>(goal, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Goal> createGoal(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody GoalDto Goal) {
    	Goal newGoal = goalService.createGoal(customUserDetails, Goal); 
    	return new ResponseEntity<>(newGoal, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@RequestBody GoalDto goal, @PathVariable int id, @AuthenticationPrincipal CustomUserDetails customUserDetails){
    	Goal newGoal = goalService.updateGoal(id, goal, customUserDetails); 
    	return new ResponseEntity<>(newGoal, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable int id) {
    	goalService.deleteGoal(id);
    }
}

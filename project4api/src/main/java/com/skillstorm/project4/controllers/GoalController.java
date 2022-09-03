package com.skillstorm.project4.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.models.Account;
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
    public ResponseEntity<String> fetchHello() {
    	
    	return new ResponseEntity<>("Hello Spring Security!", HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Account> postHello() {
    	Account account = new Account();
    	return new ResponseEntity<>(account, HttpStatus.OK);
    }
}

package com.skillstorm.project4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.services.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = { "/signup","/account"})
public class AccountController {
    @Autowired
    public AccountService accountService;
    
    @GetMapping
    public List<Account> fetchAccounts() {
    	return null;
    }
    
    @GetMapping("/{email}")
    public Account fetchAccountByEmail(@PathVariable String email) {
    	return null;
    }
    
    @PostMapping("/register")
    public Account createAccount(@RequestBody Account account) {
    	accountService.createAccount(account);
    	return null;
    }
    
    
    @PutMapping
    public Account editAccount() {
    	return null;
    }
    
    @DeleteMapping
    public void deleteAccount() {
    	
    }
}

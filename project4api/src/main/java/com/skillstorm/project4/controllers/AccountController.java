package com.skillstorm.project4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

import com.skillstorm.project4.dtos.AccountDto;
import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.models.CustomUserDetails;
import com.skillstorm.project4.services.AccountService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = { "/signup","/account"})
public class AccountController {
    @Autowired
    public AccountService accountService;
    
    @GetMapping
    public Account fetchAccountByEmail(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
    	return customUserDetails.getAccount();
    }
    
    @PostMapping("/register")
    public Account createAccount(@RequestBody AccountDto account) {
    	return accountService.createAccount(account);
    }
    
    
    @PutMapping
    public Account editAccount() {
    	return null;
    }
    
    @DeleteMapping
    public void deleteAccount() {
    	
    }
}

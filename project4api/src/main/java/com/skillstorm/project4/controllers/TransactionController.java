package com.skillstorm.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.dtos.TransactionDto;
import com.skillstorm.project4.models.CustomUserDetails;
import com.skillstorm.project4.models.Transaction;
import com.skillstorm.project4.services.TransactionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = { "/transaction/v1" })
public class TransactionController {
    @Autowired
    public TransactionService transactionService;
    
    @PostMapping("/{id}")
    public Transaction createTransaction(@AuthenticationPrincipal CustomUserDetails customUserDetails, @RequestBody TransactionDto transaction) {
    	return transactionService.createTransaction(customUserDetails, transaction);
    }
}

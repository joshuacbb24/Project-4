package com.skillstorm.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.skillstorm.project4.services.TransactionService;

public class TransactionController {
    @Autowired
    public TransactionService transactionService;
}

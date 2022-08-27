package com.skillstorm.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.services.AccountService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = { "/signup/v1/createaccount", "/account/v1/u" })
public class AccountController {
    @Autowired
    public AccountService accountService;
}

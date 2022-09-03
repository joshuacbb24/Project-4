package com.skillstorm.project4.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.models.Account;
import com.skillstorm.project4.models.CustomUserDetails;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth/v1")
public class AuthenticationController {

    @GetMapping("/login")
    public Account login(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
    	return customUserDetails.getAccount();
    }
}

package com.skillstorm.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.services.NotificationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = { "/notify/v1" })
public class NotificationController {
    @Autowired
    public NotificationService notificationService;
}

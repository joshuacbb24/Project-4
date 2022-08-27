package com.skillstorm.project4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.project4.services.BgInfoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = { "" })
public class BgInfoController {
    @Autowired
    public BgInfoService bgInfoService;
}

package com.signz.homeautomation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HealthCheckController {

    @GetMapping(value = {"/heath-check", "/"})
    public String healthCheck() {
        return "Home Automation System Is Up & Running !";
    }
}

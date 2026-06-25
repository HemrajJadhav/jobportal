package com.example.jobportal.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Allows your React app to talk to this backend
public class TestController {
    @GetMapping("/api/test")
    public String testConnection() {
        return "Connection Successful! Spring Boot is talking to React!";
    }
}

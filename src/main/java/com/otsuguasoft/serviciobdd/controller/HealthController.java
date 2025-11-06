package com.otsuguasoft.serviciobdd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/startup")
    public ResponseEntity<String> startupCheck() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/readiness")
    public ResponseEntity<String> readinessCheck() {
        return ResponseEntity.ok("OK");
    }
}


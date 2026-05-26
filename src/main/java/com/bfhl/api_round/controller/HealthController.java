package com.bfhl.api_round.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> healthCheck() {

    Map<String, Object> response = new HashMap<>();
    response.put("is_success", true);
    response.put("status", "OK");

    return ResponseEntity.ok(response);
}
}

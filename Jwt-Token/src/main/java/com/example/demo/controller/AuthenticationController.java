package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.util.JwtUtil;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        if (username == null || username.isEmpty()) {
            return ResponseEntity.badRequest().body("Username cannot be empty");
        }

        String jwtToken = jwtUtil.createToken(username);
        return ResponseEntity.ok(jwtToken);
    }
}

package com.spring.springSecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springSecurity.exchange.request.AuthRequest;
import com.spring.springSecurity.exchange.request.RegisterRequest;
import com.spring.springSecurity.exchange.response.AuthResponse;
import com.spring.springSecurity.model.User;
import com.spring.springSecurity.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired

    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        User u = new User();
        u.setName(request.getName());
        u.setEmail(request.getEmail());
        u.setPassword(request.getPassword());
        u.setRole(request.getRole());

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(

            @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
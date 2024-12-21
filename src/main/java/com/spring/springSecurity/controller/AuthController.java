package com.spring.springSecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springSecurity.exchange.request.AuthRequest;
import com.spring.springSecurity.exchange.request.RegisterRequest;
import com.spring.springSecurity.exchange.response.AuthResponse;
import com.spring.springSecurity.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AuthController {

    @Autowired

    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(

            @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

}
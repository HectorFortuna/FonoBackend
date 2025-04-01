package com.hectorfortuna.fonoBack.controller;


import com.hectorfortuna.fonoBack.dto.AuthenticationRequest;
import com.hectorfortuna.fonoBack.dto.AuthenticationResponse;
import com.hectorfortuna.fonoBack.dto.RegisterRequest;
import com.hectorfortuna.fonoBack.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}

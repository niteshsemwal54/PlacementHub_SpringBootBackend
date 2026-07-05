package com.placementhub.placementhub_backend.auth.controller;//package com.placementhub.placementhub_backend.auth.controller;

import com.placementhub.placementhub_backend.auth.dto.AuthResponse;
import com.placementhub.placementhub_backend.auth.dto.GoogleLoginRequest;
import com.placementhub.placementhub_backend.auth.dto.LoginRequest;
import com.placementhub.placementhub_backend.auth.dto.RegisterRequest;
import com.placementhub.placementhub_backend.auth.service.AuthService;
import com.placementhub.placementhub_backend.auth.service.GoogleAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private final AuthService authService;
    private final GoogleAuthService googleAuthService;

    public AuthController(AuthService authService,
                          GoogleAuthService googleAuthService) {

        this.authService = authService;
        this.googleAuthService = googleAuthService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping("/google")
    public ResponseEntity<AuthResponse> googleLogin(
            @RequestBody GoogleLoginRequest request) throws Exception {

        return ResponseEntity.ok(
                googleAuthService.authenticate(request.getIdToken())
        );
    }

}
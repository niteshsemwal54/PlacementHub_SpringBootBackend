package com.placementhub.placementhub_backend.auth.service;


import com.placementhub.placementhub_backend.auth.dto.AuthResponse;
import com.placementhub.placementhub_backend.auth.dto.LoginRequest;
import com.placementhub.placementhub_backend.auth.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}

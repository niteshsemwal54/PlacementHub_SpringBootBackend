package com.placementhub.placementhub_backend.auth.service;

import com.placementhub.placementhub_backend.auth.dto.AuthResponse;
import com.placementhub.placementhub_backend.auth.dto.LoginRequest;
import com.placementhub.placementhub_backend.auth.dto.RegisterRequest;
import com.placementhub.placementhub_backend.security.JwtService;
import com.placementhub.placementhub_backend.user.entity.AuthProvider;
import com.placementhub.placementhub_backend.user.entity.Role;
import com.placementhub.placementhub_backend.user.entity.User;
import com.placementhub.placementhub_backend.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    public AuthServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        user.setProvider(AuthProvider.LOCAL);
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(Instant.now());
        user.setLastLogin(Instant.now());
        user.setTestsAttempted(0);
        user.setPlacementScore(0);
        User savedUser = userRepository.save(user);

        return new AuthResponse(
                null,
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole().name()
        );
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email or password"));

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new RuntimeException("Invalid email or password");
        }

        user.setLastLogin(Instant.now());
        userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
package com.placementhub.placementhub_backend.auth.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.placementhub.placementhub_backend.auth.dto.AuthResponse;
import com.placementhub.placementhub_backend.security.JwtService;
import com.placementhub.placementhub_backend.user.entity.AuthProvider;
import com.placementhub.placementhub_backend.user.entity.Role;
import com.placementhub.placementhub_backend.user.entity.User;
import com.placementhub.placementhub_backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;

@Service
public class GoogleAuthService {

    @Value("${google.client-id}")
    private String clientId;

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public GoogleAuthService(UserRepository userRepository,
                             JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public AuthResponse authenticate(String idTokenString) throws Exception {

        GoogleIdTokenVerifier verifier =
                new GoogleIdTokenVerifier.Builder(
                        new NetHttpTransport(),
                        GsonFactory.getDefaultInstance())
                        .setAudience(Collections.singletonList(clientId))
                        .build();

        GoogleIdToken idToken = verifier.verify(idTokenString);

        if (idToken == null) {
            throw new RuntimeException("Invalid Google Token");
        }

        GoogleIdToken.Payload payload = idToken.getPayload();

        String email = payload.getEmail();
        String name = (String) payload.get("name");
        String picture = (String) payload.get("picture");

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null) {

            user = new User();

            user.setEmail(email);
            user.setName(name);
            user.setPassword(null);
            user.setProvider(AuthProvider.GOOGLE);
            user.setRole(Role.USER);
            user.setProfilePicture(picture);
            user.setCreatedAt(Instant.now());
            user.setUpdatedAt(Instant.now());
            user.setTestsAttempted(0);
            user.setPlacementScore(0);
            userRepository.save(user);
        }

        String jwt = jwtService.generateToken(user);

        return new AuthResponse(
                jwt,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
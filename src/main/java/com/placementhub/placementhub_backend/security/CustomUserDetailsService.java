package com.placementhub.placementhub_backend.security;

import com.placementhub.placementhub_backend.user.entity.User;
import com.placementhub.placementhub_backend.user.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        String password = user.getPassword();

        if (password == null || password.isBlank()) {
            password = "{noop}google-user";
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                password,
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );
    }
}
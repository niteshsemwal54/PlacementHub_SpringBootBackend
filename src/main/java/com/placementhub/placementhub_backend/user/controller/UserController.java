package com.placementhub.placementhub_backend.user.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public Map<String, Object> me(Authentication authentication) {

        Map<String, Object> response = new HashMap<>();

        response.put("email", authentication.getName());
        response.put("authorities", authentication.getAuthorities());

        return response;
    }
}
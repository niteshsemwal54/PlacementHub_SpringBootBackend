package com.placementhub.placementhub_backend.dashboard.controller;

import com.placementhub.placementhub_backend.dashboard.dto.DashboardResponse;
import com.placementhub.placementhub_backend.dashboard.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public ResponseEntity<DashboardResponse> getDashboard(
            Authentication authentication) {

        return ResponseEntity.ok(
                dashboardService.getDashboard(authentication.getName())
        );
    }
}
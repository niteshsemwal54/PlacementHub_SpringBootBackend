package com.placementhub.placementhub_backend.dashboard.service;

import com.placementhub.placementhub_backend.dashboard.dto.DashboardResponse;

public interface DashboardService {

    DashboardResponse getDashboard(String email);

}
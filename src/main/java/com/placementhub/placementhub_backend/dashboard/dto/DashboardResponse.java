package com.placementhub.placementhub_backend.dashboard.dto;

import java.util.List;

public class DashboardResponse {

    private DashboardUserDto user;

    private List<RecentTestDto> recentTests;

    private List<LeaderboardUserDto> leaderboard;

    public DashboardResponse() {
    }

    public DashboardResponse(DashboardUserDto user,
                             List<RecentTestDto> recentTests,
                             List<LeaderboardUserDto> leaderboard) {
        this.user = user;
        this.recentTests = recentTests;
        this.leaderboard = leaderboard;
    }

    public DashboardUserDto getUser() {
        return user;
    }

    public void setUser(DashboardUserDto user) {
        this.user = user;
    }

    public List<RecentTestDto> getRecentTests() {
        return recentTests;
    }

    public void setRecentTests(List<RecentTestDto> recentTests) {
        this.recentTests = recentTests;
    }

    public List<LeaderboardUserDto> getLeaderboard() {
        return leaderboard;
    }

    public void setLeaderboard(List<LeaderboardUserDto> leaderboard) {
        this.leaderboard = leaderboard;
    }
}
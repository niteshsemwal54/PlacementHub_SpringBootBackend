package com.placementhub.placementhub_backend.dashboard.dto;

public class LeaderboardUserDto {

    private String id;

    private String name;

    private String profilePicture;

    private double placementScore;

    private int testsAttempted;

    public LeaderboardUserDto() {
    }

    public LeaderboardUserDto(String id,
                              String name,
                              String profilePicture,
                              double placementScore,
                              int testsAttempted) {
        this.id = id;
        this.name = name;
        this.profilePicture = profilePicture;
        this.placementScore = placementScore;
        this.testsAttempted = testsAttempted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public double getPlacementScore() {
        return placementScore;
    }

    public void setPlacementScore(double placementScore) {
        this.placementScore = placementScore;
    }

    public int getTestsAttempted() {
        return testsAttempted;
    }

    public void setTestsAttempted(int testsAttempted) {
        this.testsAttempted = testsAttempted;
    }
}
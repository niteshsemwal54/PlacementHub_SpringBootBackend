package com.placementhub.placementhub_backend.dashboard.dto;

public class DashboardUserDto {

    private String id;

    private String name;

    private String email;

    private String profilePicture;

    private int testsAttempted;

    private double placementScore;

    public DashboardUserDto() {
    }

    public DashboardUserDto(String id,
                            String name,
                            String email,
                            String profilePicture,
                            int testsAttempted,
                            double placementScore) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profilePicture = profilePicture;
        this.testsAttempted = testsAttempted;
        this.placementScore = placementScore;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public int getTestsAttempted() {
        return testsAttempted;
    }

    public void setTestsAttempted(int testsAttempted) {
        this.testsAttempted = testsAttempted;
    }

    public double getPlacementScore() {
        return placementScore;
    }

    public void setPlacementScore(double placementScore) {
        this.placementScore = placementScore;
    }
}
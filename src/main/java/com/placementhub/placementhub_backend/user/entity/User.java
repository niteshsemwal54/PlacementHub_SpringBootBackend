package com.placementhub.placementhub_backend.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    private Role role;

    private AuthProvider provider;

    private String profilePicture;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant lastLogin;

    private int testsAttempted;

    private int placementScore;

    public User() {
    }

    public User(String id, String name, String email, String password,
                Role role, AuthProvider provider, String profilePicture,
                Instant createdAt, Instant updatedAt, Instant lastLogin,
                int testsAttempted, int placementScore) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.provider = provider;
        this.profilePicture = profilePicture;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastLogin = lastLogin;
        this.testsAttempted = testsAttempted;
        this.placementScore = placementScore;
    }
    public int getTestsAttempted() {
        return testsAttempted;
    }

    public void setTestsAttempted(int testsAttempted) {
        this.testsAttempted = testsAttempted;
    }

    public int getPlacementScore() {
        return placementScore;
    }

    public void setPlacementScore(int placementScore) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Instant lastLogin) {
        this.lastLogin = lastLogin;
    }
}
package com.placementhub.placementhub_backend.dashboard.dto;

import java.time.Instant;

public class RecentTestDto {

    private String attemptId;

    private String topic;

    private int score;

    private double percentage;

    private Instant submittedAt;

    public RecentTestDto() {
    }

    public RecentTestDto(String attemptId,
                         String topic,
                         int score,
                         double percentage,
                         Instant submittedAt) {
        this.attemptId = attemptId;
        this.topic = topic;
        this.score = score;
        this.percentage = percentage;
        this.submittedAt = submittedAt;
    }

    public String getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(String attemptId) {
        this.attemptId = attemptId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public Instant getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Instant submittedAt) {
        this.submittedAt = submittedAt;
    }
}
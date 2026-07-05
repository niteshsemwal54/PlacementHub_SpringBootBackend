package com.placementhub.placementhub_backend.test.dto;

import java.time.Instant;
import java.util.List;

public class TestReviewResponse {

    private String attemptId;

    private String topic;

    private int score;

    private double percentage;

    private int correctAnswers;

    private int wrongAnswers;

    private int skippedQuestions;

    private Instant submittedAt;

    private List<TestReviewQuestionDto> questions;

    public TestReviewResponse() {
    }

    public TestReviewResponse(String attemptId,
                              String topic,
                              int score,
                              double percentage,
                              int correctAnswers,
                              int wrongAnswers,
                              int skippedQuestions,
                              Instant submittedAt,
                              List<TestReviewQuestionDto> questions) {

        this.attemptId = attemptId;
        this.topic = topic;
        this.score = score;
        this.percentage = percentage;
        this.correctAnswers = correctAnswers;
        this.wrongAnswers = wrongAnswers;
        this.skippedQuestions = skippedQuestions;
        this.submittedAt = submittedAt;
        this.questions = questions;
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

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public int getSkippedQuestions() {
        return skippedQuestions;
    }

    public void setSkippedQuestions(int skippedQuestions) {
        this.skippedQuestions = skippedQuestions;
    }

    public Instant getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Instant submittedAt) {
        this.submittedAt = submittedAt;
    }

    public List<TestReviewQuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<TestReviewQuestionDto> questions) {
        this.questions = questions;
    }
}
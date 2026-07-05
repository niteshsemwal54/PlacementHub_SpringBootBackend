package com.placementhub.placementhub_backend.test.dto;

import java.time.Instant;
import java.util.List;

public class TestSubmissionRequest {

    private String topic;

    private int totalQuestions;

    private int correctAnswers;

    private int wrongAnswers;

    private int skippedQuestions;

    private double percentage;

    private int score;

    private int totalTimeTaken;

    private Instant submittedAt;

    private List<QuestionAnswerDto> answers;

    public TestSubmissionRequest() {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
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

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalTimeTaken() {
        return totalTimeTaken;
    }

    public void setTotalTimeTaken(int totalTimeTaken) {
        this.totalTimeTaken = totalTimeTaken;
    }

    public Instant getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Instant submittedAt) {
        this.submittedAt = submittedAt;
    }

    public List<QuestionAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<QuestionAnswerDto> answers) {
        this.answers = answers;
    }
}
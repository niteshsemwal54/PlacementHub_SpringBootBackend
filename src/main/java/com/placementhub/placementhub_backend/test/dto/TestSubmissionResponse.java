package com.placementhub.placementhub_backend.test.dto;

public class TestSubmissionResponse {

    private boolean success;

    private String message;

    private String attemptId;

    public TestSubmissionResponse() {
    }

    public TestSubmissionResponse(boolean success,
                                  String message,
                                  String attemptId) {
        this.success = success;
        this.message = message;
        this.attemptId = attemptId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(String attemptId) {
        this.attemptId = attemptId;
    }
}
package com.placementhub.placementhub_backend.question.entity;

public class QuestionOption {

    private String id;

    private String text;

    public QuestionOption() {
    }

    public QuestionOption(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
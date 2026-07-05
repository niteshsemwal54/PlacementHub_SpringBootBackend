package com.placementhub.placementhub_backend.test.dto;

import com.placementhub.placementhub_backend.question.entity.QuestionOption;

import java.util.List;

public class TestReviewQuestionDto {

    private String questionId;

    private String question;

    private List<QuestionOption> options;

    private String selectedOption;

    private String correctOption;

    private boolean isCorrect;

    private boolean markedForReview;

    private int timeTaken;

    public TestReviewQuestionDto() {
    }

    public TestReviewQuestionDto(String questionId,
                                 String question,
                                 List<QuestionOption> options,
                                 String selectedOption,
                                 String correctOption,
                                 boolean isCorrect,
                                 boolean markedForReview,
                                 int timeTaken) {
        this.questionId = questionId;
        this.question = question;
        this.options = options;
        this.selectedOption = selectedOption;
        this.correctOption = correctOption;
        this.isCorrect = isCorrect;
        this.markedForReview = markedForReview;
        this.timeTaken = timeTaken;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<QuestionOption> getOptions() {
        return options;
    }

    public void setOptions(List<QuestionOption> options) {
        this.options = options;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isMarkedForReview() {
        return markedForReview;
    }

    public void setMarkedForReview(boolean markedForReview) {
        this.markedForReview = markedForReview;
    }

    public int getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(int timeTaken) {
        this.timeTaken = timeTaken;
    }
}
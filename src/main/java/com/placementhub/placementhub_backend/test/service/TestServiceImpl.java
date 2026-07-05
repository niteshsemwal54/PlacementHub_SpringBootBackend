package com.placementhub.placementhub_backend.test.service;

import com.mongodb.client.model.Filters;
import com.placementhub.placementhub_backend.test.dto.*;
import com.placementhub.placementhub_backend.test.entity.TestAttempt;
import com.placementhub.placementhub_backend.test.repository.TestAttemptRepository;
import com.placementhub.placementhub_backend.user.entity.User;
import com.placementhub.placementhub_backend.user.repository.UserRepository;
import org.bson.Document;
import org.springframework.stereotype.Service;
import com.placementhub.placementhub_backend.question.entity.QuestionOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;
@Service
public class TestServiceImpl implements TestService {

    private final TestAttemptRepository testAttemptRepository;
    private final UserRepository userRepository;

    private final MongoClient mongoClient;

    public TestServiceImpl(TestAttemptRepository testAttemptRepository,
                           UserRepository userRepository,
                           MongoClient mongoClient) {

        this.testAttemptRepository = testAttemptRepository;
        this.userRepository = userRepository;
        this.mongoClient = mongoClient;
    }
    @Override
    public TestSubmissionResponse submitTest(TestSubmissionRequest request,
                                             String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        TestAttempt attempt = getTestAttempt(request, user);

        // Update user statistics
        user.setTestsAttempted(user.getTestsAttempted() + 1);

        user.setPlacementScore(-1);

        userRepository.save(user);

        TestAttempt savedAttempt =
                testAttemptRepository.save(attempt);

        return new TestSubmissionResponse(
                true,
                "Test submitted successfully",
                savedAttempt.getId()
        );
    }

    private static TestAttempt getTestAttempt(TestSubmissionRequest request, User user) {
        TestAttempt attempt = new TestAttempt();

        attempt.setUserId(user.getId());
        attempt.setTopic(request.getTopic());

        attempt.setTotalQuestions(request.getTotalQuestions());
        attempt.setCorrectAnswers(request.getCorrectAnswers());
        attempt.setWrongAnswers(request.getWrongAnswers());
        attempt.setSkippedQuestions(request.getSkippedQuestions());

        attempt.setPercentage(request.getPercentage());
        attempt.setScore(request.getScore());

        attempt.setTotalTimeTaken(request.getTotalTimeTaken());

        attempt.setSubmittedAt(request.getSubmittedAt());

        attempt.setAnswers(request.getAnswers());
        return attempt;
    }

    @Override
    public TestReviewResponse getTestReview(String attemptId,
                                            String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        TestAttempt attempt = testAttemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Test attempt not found"));

        if (!attempt.getUserId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized");
        }

        MongoDatabase database = mongoClient.getDatabase("aptitude");
        MongoCollection<Document> collection = database.getCollection("questions");

        List<TestReviewQuestionDto> questions = new ArrayList<>();

        for (QuestionAnswerDto answer : attempt.getAnswers()) {

            Document document = collection.find(
                    Filters.eq("_id", new ObjectId(answer.getQuestionId()))
            ).first();

            if (document == null) {
                throw new RuntimeException(
                        "Question not found : " + answer.getQuestionId());
            }

            List<QuestionOption> options = new ArrayList<>();

            List<Document> optionDocs =
                    document.getList("options", Document.class);

            if (optionDocs != null) {

                for (Document option : optionDocs) {

                    options.add(new QuestionOption(
                            option.getString("id"),
                            option.getString("text")
                    ));
                }
            }

            String correctAnswer = document.getString("correctAnswer");

            boolean isCorrect =
                    correctAnswer.equals(answer.getSelectedOption());

            questions.add(

                    new TestReviewQuestionDto(

                            answer.getQuestionId(),

                            document.getString("question"),

                            options,

                            answer.getSelectedOption(),

                            correctAnswer,

                            isCorrect,

                            answer.isMarkedForReview(),

                            answer.getTimeTaken()
                    )
            );
        }

        return new TestReviewResponse(

                attempt.getId(),

                attempt.getTopic(),

                attempt.getScore(),

                attempt.getPercentage(),

                attempt.getCorrectAnswers(),

                attempt.getWrongAnswers(),

                attempt.getSkippedQuestions(),

                attempt.getSubmittedAt(),

                questions
        );
    }
}
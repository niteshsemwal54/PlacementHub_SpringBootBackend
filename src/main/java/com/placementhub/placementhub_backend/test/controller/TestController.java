package com.placementhub.placementhub_backend.test.controller;

import com.placementhub.placementhub_backend.test.dto.TestSubmissionRequest;
import com.placementhub.placementhub_backend.test.dto.TestSubmissionResponse;
import com.placementhub.placementhub_backend.test.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import com.placementhub.placementhub_backend.test.dto.TestReviewResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/tests")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/submit")
    public ResponseEntity<TestSubmissionResponse> submitTest(
            @RequestBody TestSubmissionRequest request,
            Authentication authentication) {

        TestSubmissionResponse response =
                testService.submitTest(request, authentication.getName());

        return ResponseEntity.ok(response);
    }


    @GetMapping("/history/{attemptId}")
    public ResponseEntity<TestReviewResponse> getTestReview(
            @PathVariable String attemptId,
            Authentication authentication) {

        return ResponseEntity.ok(

                testService.getTestReview(
                        attemptId,
                        authentication.getName()
                )
        );
    }
}

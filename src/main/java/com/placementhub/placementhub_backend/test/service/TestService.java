package com.placementhub.placementhub_backend.test.service;

import com.placementhub.placementhub_backend.test.dto.TestSubmissionRequest;
import com.placementhub.placementhub_backend.test.dto.TestSubmissionResponse;
import com.placementhub.placementhub_backend.test.dto.TestReviewResponse;

public interface TestService {

    TestSubmissionResponse submitTest(
            TestSubmissionRequest request,
            String email
    );
    TestReviewResponse getTestReview(
            String attemptId,
            String email
    );
}
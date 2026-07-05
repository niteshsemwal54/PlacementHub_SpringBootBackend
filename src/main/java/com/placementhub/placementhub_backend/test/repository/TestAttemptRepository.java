package com.placementhub.placementhub_backend.test.repository;

import com.placementhub.placementhub_backend.test.entity.TestAttempt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestAttemptRepository
        extends MongoRepository<TestAttempt, String> {

    List<TestAttempt> findByUserIdOrderBySubmittedAtDesc(String userId);

    List<TestAttempt> findTop5ByUserIdOrderBySubmittedAtDesc(String userId);
}
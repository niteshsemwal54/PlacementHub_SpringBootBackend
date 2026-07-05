package com.placementhub.placementhub_backend.question.repository;

import com.placementhub.placementhub_backend.question.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository
        extends MongoRepository<Question, String> {
}
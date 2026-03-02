package com.spring.QuoraReactiveApp.Repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.QuoraReactiveApp.Entity.Answer;
import reactor.core.publisher.Flux;

@Repository
public interface AnswerRepo extends ReactiveMongoRepository<Answer,String> {

    Flux<Answer> findByQuestionId(String questionId);
}
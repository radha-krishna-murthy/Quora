package com.spring.QuoraReactiveApp.Repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.QuoraReactiveApp.Entity.Answer;
@Repository
public interface AnswerRepo extends ReactiveMongoRepository<Answer,String> {

    
}
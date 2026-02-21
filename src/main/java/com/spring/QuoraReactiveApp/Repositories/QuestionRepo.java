package com.spring.QuoraReactiveApp.Repositories;

import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Repository
public interface QuestionRepo extends ReactiveMongoRepository<Question,String> {

    Flux<Question> findByAuthorId(String authorId);
    Mono<Long> countByAuthorId(String authorId);
    Flux<Question>findAll10Questions(String cursor,Pageable pageable);
    @Query("{ $text: { $search: ?0 } }")
    Flux<Question> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(String searchTerm, Pageable pageable);
    Flux<Question> findByCreatedAtGreaterThanOrderByCreatedAtAsc(LocalDateTime cursor, Pageable pageable);

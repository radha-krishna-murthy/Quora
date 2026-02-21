package com.spring.QuoraReactiveApp.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.spring.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;

import java.time.LocalDateTime;

public interface IQuestionService {
    Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO question);
    Flux<QuestionResponseDTO> paginationOffset(String searchTerm,int size,int page);
    Flux<QuestionResponseDTO> paginationCursor(String cursor, int size);

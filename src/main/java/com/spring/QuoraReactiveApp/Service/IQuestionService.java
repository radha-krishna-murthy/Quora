package com.spring.QuoraReactiveApp.Service;

import java.util.List;

import com.spring.QuoraReactiveApp.Entity.QuestionElasticDocument;
import com.spring.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO);

    Flux<QuestionResponseDTO> paginationOffset(String searchTerm, int page, int size);

    Flux<QuestionResponseDTO> paginationCursor(String cursor, int size);

    Mono<QuestionResponseDTO> getQuestionById(String id);

    List<QuestionElasticDocument>searchQuestionByElasticSearch(String query);
    
}

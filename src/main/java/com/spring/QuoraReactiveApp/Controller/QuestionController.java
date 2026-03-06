package com.spring.QuoraReactiveApp.Controller;

import com.spring.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;
import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.Entity.QuestionElasticDocument;
import com.spring.QuoraReactiveApp.Service.IQuestionService;
import com.spring.QuoraReactiveApp.Service.IquestionIndexService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    private final IQuestionService questionService;
    private final IquestionIndexService qIndexService;

    @PostMapping("/create")
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO);
    }
    @GetMapping("/search")
    public Flux<QuestionResponseDTO> paginationOffset(
            @RequestParam String searchTerm,
            @RequestParam int page,
            @RequestParam int size){
        return questionService.paginationOffset(searchTerm,page,size);
    }

    @GetMapping("/search2")
    public Flux<QuestionResponseDTO> paginationCursor(
            @RequestParam String cursor,
            @RequestParam int size) {
        return questionService.paginationCursor(cursor, size);
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDTO> getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Question not found")));
    }
    @GetMapping("/elasticsearch")
    public Flux<QuestionElasticDocument> getQuestionByElasticSearch(@RequestParam String query) {
        return questionService.searchQuestionByElasticSearch(query);
        
    }
}

package com.spring.QuoraReactiveApp.Controller;

import com.spring.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;
import com.spring.QuoraReactiveApp.Service.IQuestionService;
import lombok.RequiredArgsConstructor;
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
}

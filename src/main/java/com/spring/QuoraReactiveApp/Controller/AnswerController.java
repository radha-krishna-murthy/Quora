package com.spring.QuoraReactiveApp.Controller;

import com.spring.QuoraReactiveApp.Service.IAnswerService;
import com.spring.QuoraReactiveApp.dto.AnswerRequestDTO;
import com.spring.QuoraReactiveApp.dto.AnswerResponeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {

    private final IAnswerService answerService;

    @PostMapping("/create")
    public Mono<AnswerResponeDTO> createAnswer(@RequestBody AnswerRequestDTO answerRequestDTO) {
        return answerService.createAnswer(answerRequestDTO);
    }

    @GetMapping("/{id}")
    public Mono<AnswerResponeDTO> getAnswerById(@PathVariable String id) {
        return answerService.getAnswerById(id)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found")));
    }

   @GetMapping("/question/{questionId}")
    public Flux<AnswerResponeDTO> getAnswersByQuestionId(@PathVariable String questionId) {
        return answerService.getAnswersByQuestionId(questionId);
    } 

    @PutMapping("/{id}")
    public Mono<AnswerResponeDTO> updateAnswer(@PathVariable String id,
                                               @RequestBody AnswerRequestDTO answerRequestDTO) {
        return answerService.updateAnswer(id, answerRequestDTO)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found")));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAnswer(@PathVariable String id) {
        return answerService.deleteAnswer(id);
    }
}


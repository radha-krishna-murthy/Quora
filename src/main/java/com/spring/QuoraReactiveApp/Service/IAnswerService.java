package com.spring.QuoraReactiveApp.Service;

import com.spring.QuoraReactiveApp.dto.AnswerRequestDTO;
import com.spring.QuoraReactiveApp.dto.AnswerResponeDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAnswerService {

    Mono<AnswerResponeDTO> createAnswer(AnswerRequestDTO answerRequestDTO);

    Mono<AnswerResponeDTO> getAnswerById(String id);

    Flux<AnswerResponeDTO> getAnswersByQuestionId(String questionId);

    Mono<AnswerResponeDTO> updateAnswer(String id, AnswerRequestDTO answerRequestDTO);

    Mono<Void> deleteAnswer(String id);
}

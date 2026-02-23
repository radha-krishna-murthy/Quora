package com.spring.QuoraReactiveApp.Service;

import com.spring.QuoraReactiveApp.Entity.Answer;
import com.spring.QuoraReactiveApp.dto.AnswerRequestDTO;
import com.spring.QuoraReactiveApp.dto.AnswerResponeDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAnswerService {

 public Mono<AnswerResponeDTO>createAnswer(AnswerRequestDTO answerRequestDTO);
 public Flux<AnswerResponeDTO> getAnswersById(String id);    
}

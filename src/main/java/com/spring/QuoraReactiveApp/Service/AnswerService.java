package com.spring.QuoraReactiveApp.Service;

import com.spring.QuoraReactiveApp.Entity.Answer;
import com.spring.QuoraReactiveApp.Repositories.AnswerRepo;
import com.spring.QuoraReactiveApp.dto.AnswerRequestDTO;
import com.spring.QuoraReactiveApp.dto.AnswerResponeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService implements IAnswerService {

    private final AnswerRepo answerRepo;

    @Override
    public Mono<AnswerResponeDTO> createAnswer(AnswerRequestDTO answerRequestDTO) {
        Answer answer = Answer.builder()
                .content(answerRequestDTO.getContent())
                .questionId(answerRequestDTO.getQuestionId())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return answerRepo.save(answer)
                .map(this::toDto);
    }

    @Override
    public Mono<AnswerResponeDTO> getAnswerById(String id) {
        return answerRepo.findById(id)
                .map(this::toDto);
    }

    @Override
    public Flux<AnswerResponeDTO> getAnswersByQuestionId(String questionId) {
        return answerRepo.findByQuestionId(questionId)
                .map(this::toDto);
    }

    @Override
    public Mono<AnswerResponeDTO> updateAnswer(String id, AnswerRequestDTO answerRequestDTO) {
        return answerRepo.findById(id)
                .flatMap(existing -> {
                    existing.setContent(answerRequestDTO.getContent());
                    existing.setQuestionId(answerRequestDTO.getQuestionId());
                    existing.setUpdatedAt(LocalDateTime.now());
                    return answerRepo.save(existing);
                })
                .map(this::toDto);
    }

    @Override
    public Mono<Void> deleteAnswer(String id) {
        return answerRepo.deleteById(id);
    }

    private AnswerResponeDTO toDto(Answer answer) {
        return AnswerResponeDTO.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .createdAt(answer.getCreatedAt())
                .updatedAt(answer.getUpdatedAt())
                .build();
    }
}


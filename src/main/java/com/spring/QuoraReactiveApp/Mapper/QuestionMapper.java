package com.spring.QuoraReactiveApp.Mapper;

import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionMapper {

    public static QuestionResponseDTO toQuestionResponseDTO(Question question) {
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .build();
    }
}

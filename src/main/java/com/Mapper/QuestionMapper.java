package com.Mapper;
import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;

public class QuestionMapper {

    public static QuestionResponseDTO tQuestionResponseDTO(Question question) {
        if (question == null) return null;
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .build();
    }

}


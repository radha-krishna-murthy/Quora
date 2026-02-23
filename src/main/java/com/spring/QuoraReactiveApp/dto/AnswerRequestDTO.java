package com.spring.QuoraReactiveApp.dto;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AnswerRequestDTO {
    private String content;
    private String questionId;
}

package com.spring.QuoraReactiveApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequestDTO {
    @Size(min=10,max=100)
    @NotBlank(message = "title shoudlnt be empty")
    private String title;
    @Size(min=10,max=1000)
    private String content;
}

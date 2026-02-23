package com.spring.QuoraReactiveApp.Entity;
import java.time.LocalDateTime;

// import org.springframework.data.annotation.CreatedAt;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
// import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Builder
@Document(collection = "answers")
public class Answer {
    @Id
    private String id;
    @NotBlank(message = "content should not be blank")
    @Size(min = 10, max = 1000, message = "content should be between 10 and 1000 characters")
    private String content;
    @Indexed
    private String questionId;
    @CreatedDate
    private LocalDateTime createdAt;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
}

package com.spring.QuoraReactiveApp.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Document(indexName = "questions")
public class QuestionElasticDocument {
    
    @Id
    private String id;

    private String title;

    private String content;
}

package com.spring.QuoraReactiveApp.Service;

import org.springframework.stereotype.Service;

import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.Entity.QuestionElasticDocument;
import com.spring.QuoraReactiveApp.Repositories.QuestionDocumentRepo;
import lombok.RequiredArgsConstructor;

@Service
// @AllArgsConstructor
@RequiredArgsConstructor
public class QuestionIndexService implements IquestionIndexService{
    private final QuestionDocumentRepo questionDocumentRepo;

    @Override
    public void createQuestionIndex(Question question){
        QuestionElasticDocument document=QuestionElasticDocument.builder()
        .id(question.getId())
        .content(question.getContent())
        .title(question.getTitle())
        .build();
        questionDocumentRepo.save(document);
    }
    
}

package com.spring.QuoraReactiveApp.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.spring.QuoraReactiveApp.Repositories.QuestionRepo;
import com.spring.QuoraReactiveApp.events.ViewCountEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data

@Service
@AllArgsConstructor
// @RequiredArgsConstructor
public class KafkaEventConsumer {
    private final QuestionRepo questionRepo;
    public void consumeEventCount(ViewCountEvent viewCountEvent){
        questionRepo.findById(viewCountEvent.getTargetId()).
        flatMap(question->{
            question.setViews(question.getViews()+1);
            return questionRepo.save(question);
        })
        .subscribe(updatedQuestion->{
            System.out.println("view cnt incremented for question"+ updatedQuestion.getId());
        },
        error->{
            System.out.println("Error incrementing viewcnt ofr question!!!");
    });
    }
}
/*
its very simple now we have i mporterd kafkalistener  for particular consumer! bnow jsut update the db

public final QuestionRepo questionRepo;




*/

package com.spring.QuoraReactiveApp.consumers;

import org.springframework.stereotype.Service;

import com.spring.QuoraReactiveApp.Repositories.LikeRepo;
import com.spring.QuoraReactiveApp.events.LikeNotifyEvent;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LikeNotifyConsumer {
   private final LikeRepo likeRepo;

   public void consumeLikeNotifyEvent(LikeNotifyEvent likeNotifyEvent){
        likeRepo.findById(likeNotifyEvent.getTargetId())
        .subscribe(likedQuestion->{
            System.out.println("Notified about the like for this id"+ likedQuestion.getId());
        });
   }
}

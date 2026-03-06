package com.spring.QuoraReactiveApp.Service;

import java.util.List;

import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.Repositories.FollowRepo;
import com.spring.QuoraReactiveApp.Repositories.QuestionRepo;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Data
public class UserFeedService implements IUserFeedService{
    private final FollowRepo followRepo;
    private final QuestionRepo questionRepo;
    public Flux<Question>feed(String userId){
        List<String>followingIds=followRepo.findFollowingIds(userId);
       return questionRepo.findByUserIdIn(followingIds);
    }
}

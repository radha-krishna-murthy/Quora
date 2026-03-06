package com.spring.QuoraReactiveApp.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.QuoraReactiveApp.Entity.Follow;
import com.spring.QuoraReactiveApp.Entity.Question;

import reactor.core.publisher.Flux;

public interface FollowRepo extends ReactiveMongoRepository<Follow,String> {
    List<String>findFollowingIds(String userId);
    Flux<Question>findByUserIdIn(String followingIds);
}

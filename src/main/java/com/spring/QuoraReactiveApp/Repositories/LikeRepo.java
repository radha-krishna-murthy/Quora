package com.spring.QuoraReactiveApp.Repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.QuoraReactiveApp.Entity.Like;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface LikeRepo extends ReactiveMongoRepository<Like,String> {

    Flux<Like> findByTargetIdAndTargetTypeAndIsLiked(String targetId, String targetType, Boolean isLiked);

    Mono<Like> findFirstByTargetIdAndTargetType(String targetId, String targetType);
}

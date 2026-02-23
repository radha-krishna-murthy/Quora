package com.spring.QuoraReactiveApp.Repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.QuoraReactiveApp.Entity.Like;

@Repository
public interface LikeRepo extends ReactiveMongoRepository<Like,String> {
    
}

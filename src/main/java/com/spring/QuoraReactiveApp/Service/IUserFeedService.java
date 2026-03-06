package com.spring.QuoraReactiveApp.Service;

import com.spring.QuoraReactiveApp.Entity.Question;

import reactor.core.publisher.Flux;

public interface IUserFeedService {
    Flux<Question>feed(String userId);
    
} 

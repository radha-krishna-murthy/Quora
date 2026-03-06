package com.spring.QuoraReactiveApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.Service.IFollowService;
import com.spring.QuoraReactiveApp.Service.IUserFeedService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserFeedService userservice;
    private final IFollowService followservice;
    @GetMapping("/feed")
    public Flux<Question>getFeed(@RequestParam String userId){
        return userservice.feed(userId);
    }

    @PostMapping("/follow/{userId}")
    public void following(@RequestParam  String currentUserId,@PathVariable String userId){
        followservice.saveFollow(currentUserId,userId);
    }
}

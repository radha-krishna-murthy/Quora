package com.spring.QuoraReactiveApp.Service;

import org.springframework.stereotype.Service;

import com.spring.QuoraReactiveApp.Entity.Follow;
import com.spring.QuoraReactiveApp.Repositories.FollowRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FollowService implements IFollowService {
    private final FollowRepo followRepo;

    public void saveFollow(String followerId,String followingId){
       Follow follow=Follow.builder()
       .followerId(followerId)
       .followingId(followingId)
       .build();
       followRepo.save(follow);
    }
}

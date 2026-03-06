package com.spring.QuoraReactiveApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection="follow")
@Data
@Builder
public class Follow {
    @Id
    private String id;
    private String followerId;
    private String followingId;
}

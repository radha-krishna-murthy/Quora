package com.spring.QuoraReactiveApp.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LikeRequestDTO {
    private String targetId;
    private String targetType;
    private Boolean isLike;
}
/*
targetId:questionId,AnswerId...
targetType : question | answer ...
isLike : liked or disliked the particular entity!

wehn do we want to send notification for a user??
whe someone liked it right?
so we already had a a api for that
 */

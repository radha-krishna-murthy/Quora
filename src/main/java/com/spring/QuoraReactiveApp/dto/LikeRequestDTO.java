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

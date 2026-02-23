package com.spring.QuoraReactiveApp.dto;

import java.time.LocalDateTime;

class LikeResponseDTO {
    private String id;
    private String targetId;
    private String targetType;
    private Boolean isLike;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
} 
package com.spring.QuoraReactiveApp.Entity;
import java.time.LocalDateTime;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Like {
    private String id;
    private String targetId;
    private String targetType;
    private Boolean isLiked;
    private LocalDateTime createdAt;
}

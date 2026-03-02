package com.spring.QuoraReactiveApp.events;

// import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeNotifyEvent {
    private String targetId;
    private String targetType;
    Boolean isLike;
    private LocalDateTime timestamp;
}

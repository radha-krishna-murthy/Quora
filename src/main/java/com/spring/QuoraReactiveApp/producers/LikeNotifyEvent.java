package com.spring.QuoraReactiveApp.producers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class LikeNotifyEvent {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.kafka.notify.TOPIC_NAME}")
    public String topicName;

    public void publishLikeNotification(String targetId, String targetType, boolean isLike) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("targetId", targetId);
        payload.put("targetType", targetType);
        payload.put("isLike", isLike);

        kafkaTemplate.send(topicName, targetId, payload)
                .whenComplete((result, error) -> {
                    if (error != null) {
                        System.out.println("Error sending likeNotify event to kafka " + error.getMessage());
                    }
                });
    }
}

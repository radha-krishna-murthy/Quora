package com.spring.QuoraReactiveApp.producers;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.spring.QuoraReactiveApp.events.ViewCountEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Component
@RequiredArgsConstructor
public class KafkaEventProducer {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    @Value("${spring.kafka.TOPIC_NAME}")
    private String topicName;
   
    public void publishEventCount(ViewCountEvent viewCountEvent) {
        kafkaTemplate.send(topicName,viewCountEvent.getTargetId(),viewCountEvent)
        .whenComplete((result,error)->{
            if(error!=null){
                System.err.println("Error sending view count event to Kafka: "+error.getMessage());
            }
        });
    }

   
}
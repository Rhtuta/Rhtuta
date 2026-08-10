package com.cfs.Notification_Service_Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void consumer(String message){
        System.out.println("Notification received for order: "+message);
    }
}

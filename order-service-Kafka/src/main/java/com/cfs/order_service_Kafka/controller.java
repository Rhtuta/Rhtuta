package com.cfs.order_service_Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class controller {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @PostMapping
    public String placeOrder(@RequestParam String orderId)
    {
        kafkaTemplate.send("order-topic",orderId);
        return "Order Id: "+orderId+" placed successfully!";
    }
}

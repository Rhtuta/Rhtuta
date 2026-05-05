package com.cfs.Notification_Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NotificationController {
    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    @Autowired
    private ProductAPI productAPI;

    @GetMapping("/notification")
    public String getnotification()
    {
        String port = env.getProperty("server.port");
        return "running on port: "+port+" Email: hi your order is place of iPhone, thank you for ordering!";
    }

    @GetMapping("notification/product")
    public String getProductApi()
    {
        String s1="Hello from notification API";

        //String s2= restTemplate.getForObject("http://localhost:9091/place",String.class);
        //this hardcoded programming is bad practice,use openfeign

        String s2 = productAPI.invokeProductAPI();

        return s1+s2;
    }
}

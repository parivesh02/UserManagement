package com.usermanagement.users.consumer;

import com.example.UserLicense.entity.UserLicense;
import com.usermanagement.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
public class KafkaConsumer {

    @Autowired
    private UserService userService;
    @KafkaListener(topics = "TopicKafka", groupId = "licenseKey")
    public void consume(UserLicense message)

    {
        userService.updateLicense(message);
        System.out.println("message = "+ message);
    }
}
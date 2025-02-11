package com.startiot.MassMessenger.service.impl;

import com.startiot.MassMessenger.service.NotificationService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendNotification(String message) {
        amqpTemplate.convertAndSend("exchangeName", "", message);
    }
}
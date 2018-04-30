package com.telstra.gw.sender;

import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;

/**
 * Created by abhishek.vangala on 4/2/2018.
 */
@Component
public class ResponseSender {


    @Autowired
    private JmsTemplate jmsTemplate;


    public void sendMessage(String message){
        System.out.println("Inside sender method");
        jmsTemplate.send("notificationQueue", new MessageCreator() {
            @Override
            public javax.jms.Message createMessage(Session session) throws JMSException {
                 return session.createTextMessage(message);
            }
        });
    }





}

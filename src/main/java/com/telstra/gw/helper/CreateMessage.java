package com.telstra.gw.helper;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Session;

/**
 * Created by abhishek.vangala on 4/2/2018.
 */

@Component
public class CreateMessage implements MessageCreator {

    @Override
    public javax.jms.Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("<book></book>");
    }

}

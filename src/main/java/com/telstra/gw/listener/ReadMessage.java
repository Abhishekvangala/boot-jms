package com.telstra.gw.listener;

import java.io.IOException;
import java.util.Date;

import javax.jms.JMSException;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.telstra.gw.parser1.JAXbXPath;


/**
 * Created by orcilia on 21/03/2018.
 */
@Component

public class ReadMessage {
    @Autowired
    private JAXbXPath jaXbXPath;
    @JmsListener(destination = "private.queue1") // Source is CBR ;Migration queue; ; Target is B2BGW
    public void handleMessage(ActiveMQTextMessage jmsMessage){  // XML Message Object is input (Header & Body )
    	System.out.println("Started : "+new Date().getTime());
    	try {
			String message = jmsMessage.getText();
			jmsMessage.getProperty("");
			jaXbXPath.parse(message, jmsMessage);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Ended : "+new Date().getTime());
    }
}

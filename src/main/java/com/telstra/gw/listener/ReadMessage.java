package com.telstra.gw.listener;

import com.telstra.gw.parser1.JAXbXPath;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


/**
 * Created by orcilia on 21/03/2018.
 */
@Component

public class ReadMessage {
    @Autowired
    private JAXbXPath jaXbXPath;
    @JmsListener(destination = "private.queue1") // Source is CBR ;Migration queue; ; Target is B2BGW
    public void handleMessage(String message){  // XML Message Object is input (Header & Body )
    	System.out.println("Started : "+new Date().getTime());
        jaXbXPath.parse(message);
        System.out.println("Ended : "+new Date().getTime());
    }
}

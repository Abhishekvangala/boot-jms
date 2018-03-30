package com.telstra.gw.listener;

import com.telstra.gw.parser1.JAXbXPath;
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
    @JmsListener(destination = "private.queue1")
    public void handleMessage(String message){
        jaXbXPath.parse(message);
    }
}

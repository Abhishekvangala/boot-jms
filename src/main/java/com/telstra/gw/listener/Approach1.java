package com.telstra.gw.listener;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.telstra.gw.conf.Config;
import com.telstra.gw.parser1.XpathParser;
import com.telstra.gw.sender.ResponseSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by abhishek.vangala on 3/28/2018.
 */
@Component
public class Approach1 {
    @Autowired
    private XpathParser xpathParser;
    @Autowired
    private Config config;

    @Autowired
    private ResponseSender responseSender;

    @JmsListener(destination = "private.queue2")
    public void handleMessage(String message){

        JsonObject config = this.config.getConfig();
        JsonObject convertedJson = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(message)));
            JsonArray array = config.getAsJsonArray("models");

            for(JsonElement element:array){
                JsonObject model = config.getAsJsonObject(element.getAsString());
                String evaluate = model.get("xpath").getAsString();
                if(xpathParser.evaluateModel(doc,evaluate,model.get("value").getAsString())){
                    convertedJson = xpathParser.parse(config,doc,element.getAsString());
                    System.out.println(convertedJson);
                    break;
                }
            }


            //TOdo for Resetful web service and capture response for query and response.

            //System.out.println(xpathParser.parse(config,doc,"book"));
            responseSender.sendMessage(convertedJson.toString());
        }catch(ParserConfigurationException | IOException | SAXException e){
            e.printStackTrace();
        }
    }
}

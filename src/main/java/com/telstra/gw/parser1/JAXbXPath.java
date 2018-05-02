package com.telstra.gw.parser1;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.telstra.gw.helper.CommonUtils;
import com.telstra.gw.models.SoapXmlEnvelope;

/**
 * Created by abhishek.vangala on 3/22/2018.
 */
@Component
public class JAXbXPath {

	private final Logger logger = LoggerFactory.getLogger(JAXbXPath.class);
	
	@Autowired			
	public SendToSQGateway sendToSQGateway;
	
	@Autowired
	public RestTemplate restTemplate;

	public void parse(String testMessage, ActiveMQTextMessage jmsMessage) { 
		try {
			String url = "";
			JSONObject jsonObject = new JSONObject();
			System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

			JAXBContext jaxbContext = JAXBContext.newInstance(SoapXmlEnvelope.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(testMessage);
			Object object = unmarshaller.unmarshal(reader);

			if (object != null) {
				SoapXmlEnvelope envelope = (SoapXmlEnvelope) object;
				boolean status = CommonUtils.validateSoapHeaders(envelope);
				if (status) {
					CommonUtils.generateConversationId(envelope, jmsMessage);
					jsonObject = sendToSQGateway.sendToGateway(envelope);
					url = sendToSQGateway.getURL(envelope);
					logger.info("URL " + url);
					
					HttpHeaders headers = new HttpHeaders();
			        headers.setContentType(MediaType.APPLICATION_JSON);
			        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(jsonObject,headers);
			        logger.info("Request after converting into json " + entity);
			        
			        String response = restTemplate.postForObject(url, entity, String.class);
					logger.info("Response from Gateway is " + response);
					
					logger.info("Converted using GSON " + jsonObject.toString());
					logger.info("Converted using GSON " + jsonObject.toString());
				} else {
					// generateSoapFault();
				}
			} else {
				// generateSoapFault();
			}
		} catch (Exception e) {
			// System.out.println(e.getStackTrace());
			e.printStackTrace();
		} finally {
			// Release the objects
		}

	}
}

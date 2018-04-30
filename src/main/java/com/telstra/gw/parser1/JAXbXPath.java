package com.telstra.gw.parser1;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.telstra.gw.helper.CommonUtils;
import com.telstra.gw.models.SoapXmlEnvelope;

/**
 * Created by abhishek.vangala on 3/22/2018.
 */
@Component
public class JAXbXPath {

	private final Logger logger = LoggerFactory.getLogger(JAXbXPath.class);
	private static String url;
	JSONObject jsonObject = new JSONObject();
	
	@Autowired			
	public SendToSQGateway sendToSQGateway;
	
	@Autowired
	public RestTemplate restTemplate;

	public void parse(String testMessage) { 
		try {
			System.setProperty("javax.xml.bind.context.factory", "org.eclipse.persistence.jaxb.JAXBContextFactory");

			
			JAXBContext jaxbContext = JAXBContext.newInstance(SoapXmlEnvelope.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(testMessage);
			Object object = unmarshaller.unmarshal(reader);

			if (object != null) {
				SoapXmlEnvelope envelope = (SoapXmlEnvelope) object;
				boolean status = CommonUtils.validateSoapHeaders(envelope);
				if (status) {
					/*Gson gson = new Gson();
					JsonObject jsonObject = gson.toJsonTree(envelope).getAsJsonObject();
					logger.info("Converted using GSON " + jsonObject.toString());*/
					System.out.println("envelope"+envelope);
					System.out.println("sendToSQGateway"+sendToSQGateway);
					jsonObject = sendToSQGateway.sendToGateway(envelope);
					url = sendToSQGateway.getURL(envelope);
					logger.info("URL " + url);
					
					HttpHeaders headers = new HttpHeaders();
			        headers.setContentType(MediaType.APPLICATION_JSON);
			        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(jsonObject,headers);
			        logger.info("Request after converting into json " + entity);
			        
			        String response = restTemplate.postForObject(url, entity, String.class);
					logger.info("Response from Gateway is " + response);
				
				} else {
					System.out.println("Returned False ");
					 CommonUtils.generateSoapFault();
				}
			} else {
				CommonUtils.generateSoapFault();
			}
		} catch (Exception e) {
			// System.out.println(e.getStackTrace());
			e.printStackTrace();
		} finally {
			// Release the objects
		}

	}
}

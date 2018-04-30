package com.telstra.gw.parser1;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

	public void parse(String testMessage, ActiveMQTextMessage jmsMessage) { 
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
					CommonUtils.generateConversationId(envelope, jmsMessage);
					Gson gson = new Gson();
					JsonObject jsonObject = gson.toJsonTree(envelope).getAsJsonObject();
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

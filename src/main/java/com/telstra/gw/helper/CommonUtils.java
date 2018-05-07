package com.telstra.gw.helper;

import java.util.Objects;

import javax.xml.soap.SOAPException;

import org.apache.activemq.command.ActiveMQTextMessage;

import org.apache.log4j.Logger;
import com.telstra.gw.models.SoapHeaders;
import com.telstra.gw.models.SoapXmlEnvelope;

public class CommonUtils {
	
	private static final Logger logger = Logger.getLogger(CommonUtils.class);

	private static boolean isEmpty(String value) {
		if (value != null && !"".equals(value.trim()))
			return false;
		else
			return true;
	}

	public static boolean validateSoapHeaders(SoapXmlEnvelope envelope) throws SOAPException {
		boolean status = false;
		if (envelope.getHeaders() != null && envelope.getHeaders().getSoapHeaders() != null) {
			SoapHeaders soapHeaders = envelope.getHeaders().getSoapHeaders();
			if (Objects.nonNull(soapHeaders) && !isEmpty(soapHeaders.getTransactionName())
					&& !isEmpty(soapHeaders.getSourceSystem()) && !isEmpty(soapHeaders.getServiceVersion())) {
				status = true;
			}
		}
		return status;
	}

	public static void generateConversationId(SoapXmlEnvelope envelope, ActiveMQTextMessage jmsMessage) {
		if (jmsMessage != null) {
			if (envelope.getHeaders() != null && envelope.getHeaders().getSoapHeaders() != null) {
				SoapHeaders soapHeaders = envelope.getHeaders().getSoapHeaders();
				String messageId = jmsMessage.getJMSMessageID();
				String conversationId = messageId;
				
				// need to add consumer identifier
				conversationId = conversationId + soapHeaders.getSourceSystem();

				// need to check whether consumer transaction id present or not
				conversationId = conversationId + soapHeaders.getTransactionID() != null
						? soapHeaders.getTransactionID()
						: messageId;

				// need to append type of id appended
				conversationId += "__" + messageId;
				logger.info("conversationId :: " + conversationId);

				soapHeaders.setId(conversationId);
				soapHeaders.setMessageId(messageId);
				soapHeaders.setCorrelationId(jmsMessage.getCorrelationId());
				if(jmsMessage.getReplyTo() !=null)
					soapHeaders.setReplyTo(jmsMessage.getReplyTo().getDestinationTypeAsString());
			}
		}
	}
}

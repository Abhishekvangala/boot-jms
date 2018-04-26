package com.telstra.gw.helper;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import com.telstra.gw.models.SoapHeaders;
import com.telstra.gw.models.SoapXmlEnvelope;

public class CommonUtils {

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
					&& !isEmpty(soapHeaders.getSourceSystem())) {
				soapHeaders.setId(generateConversationId());
				status = true;
			}
		}
		return status;
	}

	private static String generateConversationId() {

		return "";
	}

	public static String generateSoapFault() {
		try {
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage soapMsg = factory.createMessage();
			SOAPPart part = soapMsg.getSOAPPart();

			SOAPEnvelope envelope = part.getEnvelope();
			SOAPHeader header = envelope.getHeader();
			SOAPBody body = envelope.getBody();

			header.addTextNode("Training Details");

			SOAPBodyElement element = body
					.addBodyElement(envelope.createName("JAVA", "training", "https://jitendrazaa.com/blog"));
			element.addChildElement("WS").addTextNode("Training on Web service");

			SOAPBodyElement element1 = body
					.addBodyElement(envelope.createName("JAVA", "training", "https://jitendrazaa.com/blog"));
			element1.addChildElement("Spring").addTextNode("Training on Spring 3.0");

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			soapMsg.writeTo(out);
			String strMsg = new String(out.toByteArray());

			soapMsg.writeTo(System.out);
			System.out.println();
			System.out.println("soapMsg.toString() :: " + strMsg);
			/*
			 * FileOutputStream fOut = new FileOutputStream("SoapMessage.xml");
			 * soapMsg.writeTo(fOut);
			 */

			System.out.println();
			System.out.println("SOAP msg created");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}

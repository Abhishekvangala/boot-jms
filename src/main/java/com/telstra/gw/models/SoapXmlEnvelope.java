package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name = "Envelope", namespace = StringConstants.ENVELOP_NAMESPACE)
public class SoapXmlEnvelope {
	@XmlElement(name = "Header", type = SoapEnvelopeHeaders.class, namespace = StringConstants.ENVELOP_NAMESPACE)
	private SoapEnvelopeHeaders headers;
	@XmlElement(name = "Body",type = SoapEnvelopeBody.class , namespace = StringConstants.ENVELOP_NAMESPACE)
	private SoapEnvelopeBody body;

	public SoapEnvelopeHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(SoapEnvelopeHeaders headers) {
		this.headers = headers;
	}

	public SoapEnvelopeBody getBody() {
		return body;
	}

	public void setBody(SoapEnvelopeBody body) {
		this.body = body;
	}

	
}

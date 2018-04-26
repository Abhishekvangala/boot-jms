package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name = "Envelope", namespace = StringConstants.ENVELOP_NAMESPACE)
public class SoapXmlEnvelope {
	@XmlElement(name = "Header", type = SoapEnvelopeHeaders.class, namespace = StringConstants.ENVELOP_NAMESPACE)
	private SoapEnvelopeHeaders headers;
	@XmlElement(name = "ManageServiceQualificationRequest", namespace = StringConstants.BODY_NAMESPACE, type = SoapBody.class)
	private SoapBody soapBody;

	public SoapEnvelopeHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(SoapEnvelopeHeaders headers) {
		this.headers = headers;
	}

	public SoapBody getSoapBody() {
		return soapBody;
	}

	public void setSoapBody(SoapBody soapBody) {
		this.soapBody = soapBody;
	}

}

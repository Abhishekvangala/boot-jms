package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name = "Header", namespace = StringConstants.ENVELOP_NAMESPACE)
public class SoapEnvelopeHeaders {
	@XmlElement(name = "Header", type = SoapHeaders.class, namespace = StringConstants.HEADER_NAMESPACE)
	private SoapHeaders soapHeaders;

	public SoapHeaders getSoapHeaders() {
		return soapHeaders;
	}

	public void setSoapHeaders(SoapHeaders soapHeaders) {
		this.soapHeaders = soapHeaders;
	}

}

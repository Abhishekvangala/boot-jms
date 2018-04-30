package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name= "Body" , namespace = StringConstants.ENVELOP_NAMESPACE)
public class SoapEnvelopeBody {
	@XmlElement(name = "ManageServiceQualificationRequest",type = ManageServiceQualificationRequest.class , namespace = StringConstants.BODY_NAMESPACE)
	private ManageServiceQualificationRequest manageServiceQualificationRequest;

	public ManageServiceQualificationRequest getManageServiceQualificationRequest() {
		return manageServiceQualificationRequest;
	}

	public void setManageServiceQualificationRequest(ManageServiceQualificationRequest manageServiceQualificationRequest) {
		this.manageServiceQualificationRequest = manageServiceQualificationRequest;
	}
}

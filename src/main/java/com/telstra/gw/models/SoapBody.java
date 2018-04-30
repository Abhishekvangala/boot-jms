package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name = "Body", namespace = StringConstants.ENVELOP_NAMESPACE)
public class SoapBody {
	@XmlElement(name = "serviceQualificationType")
	private String serviceQualificationType;
	@XmlElement(name = "ManageServiceQualificationRequest", type = GeocodeDetails.class)
	private GeocodeDetails geocodeDetails;

	public String getServiceQualificationType() {
		return serviceQualificationType;
	}

	public void setServiceQualificationType(String serviceQualificationType) {
		this.serviceQualificationType = serviceQualificationType;
	}

	public GeocodeDetails getGeocodeDetails() {
		return geocodeDetails;
	}

	public void setGeocodeDetails(GeocodeDetails geocodeDetails) {
		this.geocodeDetails = geocodeDetails;
	}

}

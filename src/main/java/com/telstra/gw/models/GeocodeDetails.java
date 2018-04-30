package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "ServiceQualificationComprisedOf")
public class GeocodeDetails {
	@XmlPath("ItemInvolvesLocation/Place/latitude/text()")
	private String latitude;
	@XmlPath("ItemInvolvesLocation/Place/longitude/text()")
	private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}

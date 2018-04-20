package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement(name = "ServiceQualificationComprisedOf")
public class LocationID {

	@XmlPath("ItemInvolvesLocation/Place/ID/text()")
	private String locationId;

	@XmlElement(name = "ItemInvolvesProduct", type = Product.class)
	private Product product;

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}

package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name = "ManageServiceQualificationRequest", namespace= StringConstants.BODY_NAMESPACE)
public class ManageServiceQualificationRequest {

	@XmlPath("/serviceQualificationType/text()")
	private String serviceQualificationType;

	@XmlElement(name = "PhysicalAddress", type=PhysicalAddressDetails.class, namespace= StringConstants.BODY_NAMESPACE)
	@XmlPath("/ServiceQualification/ServiceQualificationComprisedOf/ItemInvolvesLocation/Place/PhysicalAddress")
	private PhysicalAddressDetails physicalAddressDetails;

	@XmlPath("/ServiceQualification/ServiceQualificationComprisedOf/ItemInvolvesLocation/Place/ID/text()")
	private String ID;
	
	@XmlPath("/ServiceQualification/ServiceQualificationComprisedOf/ItemInvolvesLocation/Place/Geocode/latitude/text()")
	private String latitude;
	
	@XmlPath("/ServiceQualification/ServiceQualificationComprisedOf/ItemInvolvesLocation/Place/Geocode/longitude/text()")
	private String longitude;
	
	@XmlPath("ServiceQualification/ServiceQualificationComprisedOf/type/text()")
	private String type;

	@XmlElement(name = "ItemInvolvesProduct",type = Product.class, namespace= StringConstants.BODY_NAMESPACE)
	@XmlPath("/ServiceQualification/ServiceQualificationComprisedOf/ItemInvolvesProduct")
	private Product product;
	
	public String getServiceQualificationType() {
		return serviceQualificationType;
	}
	public void setServiceQualificationType(String serviceQualificationType) {
		this.serviceQualificationType = serviceQualificationType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public PhysicalAddressDetails getPhysicalAddressDetails() {
		return physicalAddressDetails;
	}
	public void setPhysicalAddressDetails(PhysicalAddressDetails physicalAddressDetails) {
		this.physicalAddressDetails = physicalAddressDetails;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
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
	
	


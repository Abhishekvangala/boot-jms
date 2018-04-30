package com.telstra.gw.models;


import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name = "ItemInvolvesProduct", namespace= StringConstants.BODY_NAMESPACE)
public class Product {
	
	@XmlElement(name = "DescribedBy",type = DescribedBy.class , namespace = StringConstants.BODY_NAMESPACE)
	private ArrayList<DescribedBy> describedBy;

	@XmlPath("/ServiceQualification/ServiceQualificationComprisedOf/ItemInvolvesProduct/SpecifiedBy/type/text()")
	private String type;
	
	
	public ArrayList<DescribedBy> getDescribedBy() {
		return describedBy;
	}
	public void setDescribedBy(ArrayList<DescribedBy> describedBy) {
		this.describedBy = describedBy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

package com.telstra.gw.models;

import org.eclipse.persistence.oxm.annotations.XmlPath;

public class DescribedBy {
	
	@XmlPath("/ServiceQualification/ServiceQualificationComprisedOf/ItemInvolvesProduct/DescribedBy/value/text()")
	private String value;
	@XmlPath("/ServiceQualification/ServiceQualificationComprisedOf/ItemInvolvesProduct/DescribedBy/characteristic/name/text()")
	private String name;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

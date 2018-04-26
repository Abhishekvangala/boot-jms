package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name = "Header", namespace = StringConstants.HEADER_NAMESPACE)
public class SoapHeaders {

	@XmlElement(name = "transactionID", namespace = StringConstants.HEADER_NAMESPACE)
	private String transactionID;

	@XmlElement(name = "transactionName", namespace = StringConstants.HEADER_NAMESPACE)
	private String transactionName;

	@XmlElement(name = "sourceSystem", namespace = StringConstants.HEADER_NAMESPACE)
	private String sourceSystem;

	@XmlElement(name = "targetSystem", namespace = StringConstants.HEADER_NAMESPACE)
	private String targetSystem;

	@XmlElement(name = "serviceVersion", namespace = StringConstants.HEADER_NAMESPACE)
	private String serviceVersion;

	private String id;

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getTargetSystem() {
		return targetSystem;
	}

	public void setTargetSystem(String targetSystem) {
		this.targetSystem = targetSystem;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

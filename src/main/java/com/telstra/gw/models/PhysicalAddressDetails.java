package com.telstra.gw.models;

import javax.xml.bind.annotation.XmlRootElement;

import com.telstra.gw.helper.StringConstants;

@XmlRootElement(name = "PhysicalAddress")
public class PhysicalAddressDetails {
	private String levelNumber;
	private String roadNumber1;
	private String stateTerritoryCode;
	private String lotNumber;
	private String complexRoadName;
	private String postcode;
	private String localityName;
	private String roadSuffixCode;
	private String planNumber;
	private String unitTypeCode;
	private String complexRoadTypeCode;
	private String complexRoadNumber1;
	private String complexRoadNumber2;
	private String roadName;
	private String roadNumber2;
	private String secondaryComplexName;
	private String unitNumber;
	private String levelTypeCode;
	private String complexRoadSuffixCode;
	private String roadTypeCode;
	private String addressSiteName;
	
	public String getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(String levelNumber) {
		this.levelNumber = levelNumber;
	}
	public String getRoadNumber1() {
		return roadNumber1;
	}
	public void setRoadNumber1(String roadNumber1) {
		this.roadNumber1 = roadNumber1;
	}
	public String getStateTerritoryCode() {
		return stateTerritoryCode;
	}
	public void setStateTerritoryCode(String stateTerritoryCode) {
		this.stateTerritoryCode = stateTerritoryCode;
	}
	public String getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public String getComplexRoadName() {
		return complexRoadName;
	}
	public void setComplexRoadName(String complexRoadName) {
		this.complexRoadName = complexRoadName;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getLocalityName() {
		return localityName;
	}
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}
	public String getRoadSuffixCode() {
		return roadSuffixCode;
	}
	public void setRoadSuffixCode(String roadSuffixCode) {
		this.roadSuffixCode = roadSuffixCode;
	}
	public String getPlanNumber() {
		return planNumber;
	}
	public void setPlanNumber(String planNumber) {
		this.planNumber = planNumber;
	}
	public String getUnitTypeCode() {
		return unitTypeCode;
	}
	public void setUnitTypeCode(String unitTypeCode) {
		this.unitTypeCode = unitTypeCode;
	}
	public String getComplexRoadTypeCode() {
		return complexRoadTypeCode;
	}
	public void setComplexRoadTypeCode(String complexRoadTypeCode) {
		this.complexRoadTypeCode = complexRoadTypeCode;
	}
	public String getComplexRoadNumber1() {
		return complexRoadNumber1;
	}
	public void setComplexRoadNumber1(String complexRoadNumber1) {
		this.complexRoadNumber1 = complexRoadNumber1;
	}
	public String getComplexRoadNumber2() {
		return complexRoadNumber2;
	}
	public void setComplexRoadNumber2(String complexRoadNumber2) {
		this.complexRoadNumber2 = complexRoadNumber2;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getRoadNumber2() {
		return roadNumber2;
	}
	public void setRoadNumber2(String roadNumber2) {
		this.roadNumber2 = roadNumber2;
	}
	public String getSecondaryComplexName() {
		return secondaryComplexName;
	}
	public void setSecondaryComplexName(String secondaryComplexName) {
		this.secondaryComplexName = secondaryComplexName;
	}
	public String getUnitNumber() {
		return unitNumber;
	}
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}
	public String getLevelTypeCode() {
		return levelTypeCode;
	}
	public void setLevelTypeCode(String levelTypeCode) {
		this.levelTypeCode = levelTypeCode;
	}
	public String getComplexRoadSuffixCode() {
		return complexRoadSuffixCode;
	}
	public void setComplexRoadSuffixCode(String complexRoadSuffixCode) {
		this.complexRoadSuffixCode = complexRoadSuffixCode;
	}
	public String getRoadTypeCode() {
		return roadTypeCode;
	}
	public void setRoadTypeCode(String roadTypeCode) {
		this.roadTypeCode = roadTypeCode;
	}
	public String getAddressSiteName() {
		return addressSiteName;
	}
	public void setAddressSiteName(String addressSiteName) {
		this.addressSiteName = addressSiteName;
	}
}

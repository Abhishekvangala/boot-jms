package com.telstra.gw.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.telstra.gw.models.DescribedBy;
import com.telstra.gw.models.PhysicalAddressDetails;
import com.telstra.gw.models.SoapXmlEnvelope;

@Component
@SuppressWarnings("unchecked")
public class GetJSONObjects {
	
	JSONObject obj = new JSONObject();
	
	public JSONObject getLocationPayload(SoapXmlEnvelope object) {
		JSONObject product = getProductDetails(object);
		obj.clear();
		
		obj.put("locationId", object.getBody().getManageServiceQualificationRequest().getID());		
		obj.put("version", object.getHeaders().getSoapHeaders().getServiceVersion());
		obj.put("product", product);
		
		return obj;
		
	}
	
	public JSONObject getGnafIdPayload(SoapXmlEnvelope object) {
		JSONObject product = getProductDetails(object);
		obj.clear();
		
		obj.put("gnafId", object.getBody().getManageServiceQualificationRequest().getID());
		obj.put("version", object.getHeaders().getSoapHeaders().getServiceVersion());
		obj.put("product", product);
		
		return obj;
		
	}

	public JSONObject getGeoCodePayload(SoapXmlEnvelope object) {
		JSONObject product = getProductDetails(object);
		obj.clear();
		
		obj.put("latitude", object.getBody().getManageServiceQualificationRequest().getLatitude());
		obj.put("longitude", object.getBody().getManageServiceQualificationRequest().getLongitude());
		obj.put("version", object.getHeaders().getSoapHeaders().getServiceVersion());
		obj.put("product", product);
		
		return obj;
		
	}
	
	public void createPhysicalAddressPayload(String key,String value ) {
		if(value != null && value.length() != 0)
			obj.put(key, value);
	}
	
	public JSONObject getPhysicalAddressPayload(SoapXmlEnvelope object) {
		
		PhysicalAddressDetails physicalAddressDetails;
		physicalAddressDetails =object.getBody().getManageServiceQualificationRequest().getPhysicalAddressDetails();
		
		JSONObject product = getProductDetails(object);
		obj.clear();
		
		createPhysicalAddressPayload("levelNumber", physicalAddressDetails.getLevelNumber());		
		createPhysicalAddressPayload("roadNumber1", physicalAddressDetails.getRoadNumber1());		
		createPhysicalAddressPayload("stateTerritoryCode", physicalAddressDetails.getStateTerritoryCode());		
		createPhysicalAddressPayload("lotNumber", physicalAddressDetails.getLotNumber());		
		createPhysicalAddressPayload("complexRoadName", physicalAddressDetails.getComplexRoadName());		
		createPhysicalAddressPayload("postcode",physicalAddressDetails.getPostcode());		
		createPhysicalAddressPayload("localityName", physicalAddressDetails.getLocalityName());		
		createPhysicalAddressPayload("roadSuffixCode",physicalAddressDetails.getRoadSuffixCode());
		createPhysicalAddressPayload("planNumber", physicalAddressDetails.getPlanNumber());
		createPhysicalAddressPayload("unitTypeCode", physicalAddressDetails.getUnitTypeCode());
		createPhysicalAddressPayload("complexRoadTypeCode", physicalAddressDetails.getComplexRoadTypeCode());
		createPhysicalAddressPayload("complexRoadNumber1", physicalAddressDetails.getComplexRoadNumber1());
		createPhysicalAddressPayload("complexRoadNumber2",physicalAddressDetails.getComplexRoadNumber2());		
		createPhysicalAddressPayload("roadName", physicalAddressDetails.getRoadName());
		createPhysicalAddressPayload("roadNumber2",physicalAddressDetails.getRoadNumber2());
		createPhysicalAddressPayload("secondaryComplexName",physicalAddressDetails.getSecondaryComplexName());
		createPhysicalAddressPayload("unitNumber",physicalAddressDetails.getUnitNumber());
		createPhysicalAddressPayload("levelTypeCode",physicalAddressDetails.getLevelTypeCode());
		createPhysicalAddressPayload("complexRoadSuffixCode",physicalAddressDetails.getComplexRoadSuffixCode());
		createPhysicalAddressPayload("roadTypeCode",physicalAddressDetails.getRoadTypeCode());
		createPhysicalAddressPayload("addressSiteName",physicalAddressDetails.getAddressSiteName());
		
		System.out.println(physicalAddressDetails.getRoadName());
		
		System.out.println(physicalAddressDetails.getLocalityName());
		
		obj.put("version", object.getHeaders().getSoapHeaders().getServiceVersion());		
		obj.put("product", product);
		
		return obj;
		
	}
	
	public JSONObject getProductDetails(SoapXmlEnvelope object) {
		ArrayList<DescribedBy> describedBy = null;
		JSONObject product = new JSONObject();
		
		if(object.getBody().getManageServiceQualificationRequest().getProduct()!= null) {
			describedBy = object.getBody().getManageServiceQualificationRequest().getProduct().getDescribedBy(); 
			List<JSONObject> describedByArray = new ArrayList<JSONObject>();
			
			ListIterator<DescribedBy> itr = describedBy.listIterator();
			while(itr.hasNext())
			{
				JSONObject jsonObject = new JSONObject();
				DescribedBy describedBy1 = itr.next();
				if(describedBy1.getName() != null)
				jsonObject.put("name",describedBy1.getName());
				if(describedBy1.getValue() != null)
				jsonObject.put("value",describedBy1.getValue());	
				if(describedBy1.getType() != null)
				jsonObject.put("type",describedBy1.getType());
				
				describedByArray.add(jsonObject);			
			}
			product.put("productDetails", describedByArray);
			product.put("productSpecificationType", object.getBody().getManageServiceQualificationRequest().getProduct().getType());
			}
		return product;
	}


}

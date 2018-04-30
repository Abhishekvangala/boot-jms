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
	
	private ArrayList<DescribedBy> describedBy = null;
	JSONObject product = new JSONObject();
	JSONObject obj = new JSONObject();
	JSONObject DescribedBy = new JSONObject();
	
	public JSONObject getLocationPayload(SoapXmlEnvelope object) {
		if(object.getBody().getManageServiceQualificationRequest().getProduct()!= null) {
		describedBy = object.getBody().getManageServiceQualificationRequest().getProduct().getDescribedBy(); 
		List<JSONObject> describedByArray = new ArrayList<JSONObject>();
		
		ListIterator<DescribedBy> itr = describedBy.listIterator();
		while(itr.hasNext())
		{
			JSONObject jsonObject = new JSONObject();
			DescribedBy describedBy = itr.next();
			jsonObject.put("name",describedBy.getName());
			jsonObject.put("value",describedBy.getValue());
			describedByArray.add(jsonObject);			
		}
		product.put("DescribedBy", describedByArray);
		product.put("type", object.getBody().getManageServiceQualificationRequest().getProduct().getType());
		}
		obj.put("locationId", object.getBody().getManageServiceQualificationRequest().getID());
		obj.put("gnafId", object.getBody().getManageServiceQualificationRequest().getID());
		obj.put("version", object.getHeaders().getSoapHeaders().getServiceVersion());
		obj.put("product", product);
		
		return obj;
		
	}

	public JSONObject getGeoCodePayload(SoapXmlEnvelope object) {
		if(object.getBody().getManageServiceQualificationRequest().getProduct()!= null) {
		describedBy = object.getBody().getManageServiceQualificationRequest().getProduct().getDescribedBy(); 
		List<JSONObject> describedByArray = new ArrayList<JSONObject>();
		
		ListIterator<DescribedBy> itr = describedBy.listIterator();
		while(itr.hasNext())
		{
			JSONObject jsonObject = new JSONObject();
			DescribedBy describedBy = itr.next();
			jsonObject.put("name",describedBy.getName());
			jsonObject.put("value",describedBy.getValue());
			describedByArray.add(jsonObject);			
		}
		product.put("DescribedBy", describedByArray);
		product.put("type", object.getBody().getManageServiceQualificationRequest().getProduct().getType());
		}
		obj.put("latitude", object.getBody().getManageServiceQualificationRequest().getLatitude());
		obj.put("longitude", object.getBody().getManageServiceQualificationRequest().getLongitude());
		obj.put("version", object.getHeaders().getSoapHeaders().getServiceVersion());
		obj.put("product", product);
		
		return obj;
		
	}

	public JSONObject getPhysicalAddressPayload(SoapXmlEnvelope object) {
		
		PhysicalAddressDetails physicalAddressDetails;
		
		physicalAddressDetails =object.getBody().getManageServiceQualificationRequest().getPhysicalAddressDetails();
		
		if(object.getBody().getManageServiceQualificationRequest().getProduct()!= null) {
		describedBy = object.getBody().getManageServiceQualificationRequest().getProduct().getDescribedBy(); 
		List<JSONObject> describedByArray = new ArrayList<JSONObject>();
		
		ListIterator<DescribedBy> itr = describedBy.listIterator();
		while(itr.hasNext())
		{
			JSONObject jsonObject = new JSONObject();
			DescribedBy describedBy = itr.next();
			jsonObject.put("name",describedBy.getName());
			jsonObject.put("value",describedBy.getValue());
			describedByArray.add(jsonObject);			
		}
		product.put("DescribedBy", describedByArray);
		product.put("type", object.getBody().getManageServiceQualificationRequest().getProduct().getType());
		}	
		obj.put("levelNumber", physicalAddressDetails.getLevelNumber());
		obj.put("roadNumber1", physicalAddressDetails.getRoadNumber1());
		obj.put("stateTerritoryCode", physicalAddressDetails.getStateTerritoryCode());
		obj.put("lotNumber", physicalAddressDetails.getLotNumber());
		obj.put("complexRoadName", physicalAddressDetails.getComplexRoadName());
		obj.put("postcode",physicalAddressDetails.getPostcode());
		obj.put("localityName", physicalAddressDetails.getLocalityName());
		obj.put("roadSuffixCode",physicalAddressDetails.getRoadSuffixCode());
		obj.put("planNumber", physicalAddressDetails.getPlanNumber());
		obj.put("unitTypeCode", physicalAddressDetails.getUnitTypeCode());
		obj.put("complexRoadTypeCode", physicalAddressDetails.getComplexRoadTypeCode());
		obj.put("complexRoadNumber1", physicalAddressDetails.getComplexRoadNumber1());
		obj.put("complexRoadNumber2",physicalAddressDetails.getComplexRoadNumber2());
		obj.put("roadName", physicalAddressDetails.getRoadName());
		obj.put("roadNumber2",physicalAddressDetails.getRoadNumber2());
		obj.put("secondaryComplexName",physicalAddressDetails.getSecondaryComplexName());
		obj.put("unitNumber",physicalAddressDetails.getUnitNumber());
		obj.put("levelTypeCode",physicalAddressDetails.getLevelTypeCode());
		obj.put("complexRoadSuffixCode",physicalAddressDetails.getComplexRoadSuffixCode());
		obj.put("roadTypeCode",physicalAddressDetails.getRoadTypeCode());
		obj.put("addressSiteName",physicalAddressDetails.getAddressSiteName());
		
		obj.put("version", object.getHeaders().getSoapHeaders().getServiceVersion());
		obj.put("product", product);
		
		return obj;
		
	}

}

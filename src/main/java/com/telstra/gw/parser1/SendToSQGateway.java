package com.telstra.gw.parser1;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.telstra.gw.helper.GetJSONObjects;
import com.telstra.gw.models.SoapXmlEnvelope;

@Component
public class SendToSQGateway {

	@Autowired
	public GetJSONObjects getJSONObjects;
	
	private String type;	
	private String url;
	JSONObject obj = new JSONObject();
	
	public JSONObject sendToGateway(SoapXmlEnvelope envelope) {
		System.out.println("envelope"+envelope);
		type = envelope.getBody().getManageServiceQualificationRequest().getType();
		
		if(type.equalsIgnoreCase("NBNLocationID") || type.equalsIgnoreCase("GNAFID")) {
			obj = getJSONObjects.getLocationPayload(envelope);
		} 
		else if(type.equalsIgnoreCase("SpatialGeocode")) {
			obj = getJSONObjects.getGeoCodePayload(envelope);
		}
		else {
			obj = getJSONObjects.getPhysicalAddressPayload(envelope);
		}	
		return obj;		
	}

	public String getURL(SoapXmlEnvelope envelope) {
		type = envelope.getBody().getManageServiceQualificationRequest().getType();
		if(type.equalsIgnoreCase("NBNLocationID") || type.equalsIgnoreCase("GNAFID")) {
			url = "http://localhost:9000/v1/single-site-qualification-loc-id";
		} 		
		else if(type.equalsIgnoreCase("SpatialGeocode")) {
			url = "http://localhost:9000/v1/single-site-qualification-geo-code";
		}
		else {
			url = "http://localhost:9000/v1/single-site-qualification-physical-address";
		}
		return url;
	}
}

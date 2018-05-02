package com.telstra.gw.parser1;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.telstra.gw.helper.GetJSONObjects;
import com.telstra.gw.models.SoapXmlEnvelope;

@Component
public class SendToSQGateway {

	@Autowired
	public GetJSONObjects getJSONObjects;
	
	 @Autowired
	 private Environment environment;
	
	public JSONObject sendToGateway(SoapXmlEnvelope envelope) {
		System.out.println("envelope"+envelope);
		String type = envelope.getBody().getManageServiceQualificationRequest().getType();
		JSONObject obj = new JSONObject();
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
		String type = envelope.getBody().getManageServiceQualificationRequest().getType();
		String url = "";
		if(type.equalsIgnoreCase("NBNLocationID") || type.equalsIgnoreCase("GNAFID")) {
			url = environment.getProperty("EndPoint.locIdUrl");
		} 		
		else if(type.equalsIgnoreCase("SpatialGeocode")) {
			url =  environment.getProperty("EndPoint.geoCodeUrl");
		}
		else {
			url =  environment.getProperty("EndPoint.physicalAddressUrl");
		}
		return url;
	}
}

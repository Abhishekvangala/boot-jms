package com.telstra.gw.parser1;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.telstra.gw.helper.FetchData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by abhishek.vangala on 3/28/2018.
 */
@Component
public class XpathParser {

    @Autowired
    private FetchData fetcher;

    
    public JsonObject parse(JsonObject config, Node xmlInput,String modelName) throws IOException, TransformerException {
    	return parse(config,xmlInput,modelName,null);
    }
    
    
    public JsonObject parse(JsonObject config, Node local,String modelName,Node parent) throws IOException, TransformerException{
        JsonObject parsedObject = new JsonObject();

        //getting String values

        JsonObject model = config.getAsJsonObject(modelName);
        Set<Map.Entry<String, JsonElement>> retrival = null;
        if(model.getAsJsonObject("getAsString") != null) {
            retrival = model.getAsJsonObject("getAsString").entrySet();
            for (Map.Entry<String, JsonElement> element : retrival) {
                String value = fetcher.getString(element.getValue().getAsString(), local);
                if (value != null && ! value.isEmpty()) parsedObject.addProperty(element.getKey(), value);
            }
        }

        if( model.getAsJsonObject("getAsInteger") != null) {
            retrival = model.getAsJsonObject("getAsInteger").entrySet();

            for (Map.Entry<String, JsonElement> element : retrival) {
                Double value = fetcher.getNumber(element.getValue().getAsString(), local);
                if (value != null) parsedObject.addProperty(element.getKey(), value.intValue());
            }
        }

        if(model.getAsJsonObject("getAsDobule") != null) {
            retrival = model.getAsJsonObject("getAsDobule").entrySet();
            for (Map.Entry<String, JsonElement> element : retrival) {
                Double value = fetcher.getNumber(element.getValue().getAsString(), local);
                if (value != null) parsedObject.addProperty(element.getKey(), value);
            }
        }

        if(model.getAsJsonObject("getNodeSet") != null) {
            retrival = model.getAsJsonObject("getNodeSet").entrySet();
            for (Map.Entry<String, JsonElement> element : retrival) {
                NodeList nodeSet = fetcher.getNodeList(element.getValue().getAsString(), local);
                JsonArray array = new JsonArray();
                for (int i = 0; i < nodeSet.getLength(); i++) {
                    Node node = nodeSet.item(i);
                    if(! node.getNodeValue().isEmpty())
                    array.add(node.getNodeValue().trim());
                }

                if(array.size()>0)
                parsedObject.add(element.getKey(), array);
            }
        }


        if(model.getAsJsonObject("getInnerObjects") !=null) {
            retrival = model.getAsJsonObject("getInnerObjects").entrySet();

            for (Map.Entry<String, JsonElement> element : retrival) {
                String innerObject = element.getValue().getAsString();
                JsonObject innerJsonObject = parse(config, local, innerObject);
                if(innerJsonObject != null && innerJsonObject.entrySet().size()  > 0)
                parsedObject.add(element.getKey(), parse(config, local, innerObject));

            }
        }
        
        
        if(model.getAsJsonObject("getArrayofJsonObjects") !=null) {
            retrival = model.getAsJsonObject("getArrayofJsonObjects").entrySet();
            	
            for (Map.Entry<String, JsonElement> element : retrival) {
            	
            	NodeList list = fetcher.getNodeList(element.getValue().getAsJsonObject().get("listXpath").getAsString(), local);
            	
            	JsonArray array = new JsonArray();
            	
            	for(int i=0;i<list.getLength();i++) {
            		
            		Node node = list.item(i);
            		array.add(parse(config, node, element.getValue().getAsJsonObject().get("model").getAsString(), local));
            		
            	}
               /* String innerObject = element.getValue().getAsString();
                JsonObject innerJsonObject = parse(config, local, innerObject);
                if(innerJsonObject != null && innerJsonObject.entrySet().size()  > 0)
                parsedObject.add(element.getKey(), parse(config, local, innerObject));
				*/
            	
            	parsedObject.add(element.getKey(),array);
            }
        }
        
        return  parsedObject;
    }


    public boolean evaluateModel(Document dom,String evaluate,String value){
     return fetcher.evaluateModel(evaluate,dom,value);
    }
    
    
    private static String toString(Node node) throws IOException, TransformerException
    {
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer transformer = tf.newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

      StringWriter writer = new StringWriter();
      transformer.transform(new DOMSource(node), new StreamResult(writer));
      return writer.toString();
    }
    
    
    private String getXpath(Node node) {
    	
    	
    	    Node parent = node.getParentNode();
    	    if (parent == null) {
    	        return "/" + node.getNodeName();
    	    }
    	    return getXpath(parent) + "/";
    	
    }

}

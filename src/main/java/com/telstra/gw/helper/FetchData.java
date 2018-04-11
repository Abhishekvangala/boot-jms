package com.telstra.gw.helper;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.*;

/**
 * Created by abhishek.vangala on 3/28/2018.
 */
@Component
public class FetchData {

    XPath xpath = null;
    

	public NodeList getNodeList(String expression, Node doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (NodeList) exper.evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;
    }

    public  String getString(String expression, Node doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            String value = (String) exper.evaluate(doc, XPathConstants.STRING);
            if(value!= null) return value.trim();
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }

    public Node getNode(String expression, Node doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Node) exper.evaluate(doc, XPathConstants.NODE);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }


    public  Double getNumber(String expression, Node doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Double) exper.evaluate(doc, XPathConstants.NUMBER);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }

    public  Boolean getBoolean(String expression, Node doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Boolean) exper.evaluate(doc, XPathConstants.BOOLEAN);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }



    public  Boolean evaluateModel(String expression,Node doc, String value) {
        try {
            XPathExpression exper = xpath.compile(expression);
            String xmlValue =   (String) exper.evaluate(doc, XPathConstants.STRING);
            System.out.println("Inside evaluate"+xmlValue);
            if(value.equalsIgnoreCase(xmlValue)) return true;

        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return false;

    }
    
    @PostConstruct
    public void init() {
    	this.xpath = XPathFactory.newInstance().newXPath();
    	    
    	    
    	    NamespaceContext ctx = new NamespaceContext() {
    	        public String getNamespaceURI(String prefix) {
    	            if ("v20".equals(prefix)) {
    	                return "testNS1";
    	            } else if ("xsi".equals(prefix)) {
    	                return "http://www.w3.org/2001/XMLSchema-instance";
    	            }
    	            return null;
    	        }
    	        public String getPrefix(String uri) {
    	            throw new UnsupportedOperationException();
    	        }
    	        public Iterator getPrefixes(String uri) {
    	            throw new UnsupportedOperationException();
    	        }
    	    };
    	    xpath.setNamespaceContext(ctx);
    }
}

package com.telstra.gw.helper;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;

/**
 * Created by abhishek.vangala on 3/28/2018.
 */
@Component
public class FetchData {

    XPath xpath =  XPathFactory.newInstance().newXPath();

    public NodeList getNodeList(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (NodeList) exper.evaluate(doc, XPathConstants.NODESET);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;
    }

    public  String getString(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            String value = (String) exper.evaluate(doc, XPathConstants.STRING);
            if(value!= null) return value.trim();
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }

    public Node getNode(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Node) exper.evaluate(doc, XPathConstants.NODE);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }


    public  Double getNumber(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Double) exper.evaluate(doc, XPathConstants.NUMBER);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }

    public  Boolean getBoolean(String expression, Document doc) {
        try {
            XPathExpression exper = xpath.compile(expression);
            return (Boolean) exper.evaluate(doc, XPathConstants.BOOLEAN);
        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return null;

    }



    public  Boolean evaluateModel(String expression,Document doc, String value) {
        try {
            XPathExpression exper = xpath.compile(expression);
            String xmlValue =   (String) exper.evaluate(doc, XPathConstants.STRING);
            if(value.equalsIgnoreCase(xmlValue)) return true;

        } catch (XPathExpressionException ex) {
            System.out.println("Error while retreiving");
        }
        return false;

    }
}

package com.telstra.gw.models;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ItemInvolvesProduct")
public class Product {

	@XmlElement(name = "DescribedBy", type = ProductDetails.class)
	private List<ProductDetails> productDetails;

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
}

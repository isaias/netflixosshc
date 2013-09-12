package br.com.strategiatec.netflixosshc.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private String productId;
	private int quantity;

	public Product() {
	}

	public Product(String productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

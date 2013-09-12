package br.com.strategiatec.netflixosshc.domain;

public class ProductStore {

	private String productId;
	private String description;
	private float price;

	public ProductStore(String productId, String description, float price) {
		this.productId = productId;
		this.description = description;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}

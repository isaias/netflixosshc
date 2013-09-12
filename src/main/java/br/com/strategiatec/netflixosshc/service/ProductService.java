package br.com.strategiatec.netflixosshc.service;

import br.com.strategiatec.netflixosshc.domain.ProductStore;
import java.util.HashMap;
import java.util.Map;

public class ProductService {

	static final Map<String, ProductStore> products;
	static {
		products = new HashMap<String, ProductStore>();
		products.put("0001", new ProductStore("0001", "Product A", 125.09F));
		products.put("0002", new ProductStore("0002", "Product B", 1212.36F));
		products.put("0003", new ProductStore("0003", "Product C", 16.11F));
		products.put("0004", new ProductStore("0004", "Product D", 23.49F));
		products.put("0004", new ProductStore("0005", "Product E", 96.69F));
		products.put("0006", new ProductStore("0006", "Product F", 54.89F));
		products.put("0007", new ProductStore("0007", "Product G", 1.19F));
		products.put("0008", new ProductStore("0008", "Product H", 985.22F));
		products.put("0009", new ProductStore("0009", "Product I", 45.56F));
		products.put("0010", new ProductStore("0010", "Product J", 96.25F));
		products.put("0011", new ProductStore("0011", "Product K", 18.11F));
		products.put("0012", new ProductStore("0012", "Product L", 25.48F));
		products.put("0013", new ProductStore("0013", "Product M", 178.86F));
		products.put("0014", new ProductStore("0014", "Product N", 1825.1F));
	}

	public ProductService() {
	}

	public static ProductStore findProduct(String productId) {
		// 5% of timeout
		if (Math.random() > 0.95)
			try {
				Thread.sleep(8000);
			} catch (InterruptedException interruptedexception) {
			}
		return products.get(productId);
	}
}

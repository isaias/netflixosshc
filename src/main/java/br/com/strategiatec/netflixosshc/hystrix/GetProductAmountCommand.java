package br.com.strategiatec.netflixosshc.hystrix;

import java.util.List;

import br.com.strategiatec.netflixosshc.domain.Product;
import br.com.strategiatec.netflixosshc.domain.ProductStore;
import br.com.strategiatec.netflixosshc.service.ProductService;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetProductAmountCommand extends HystrixCommand<Float> {

	final List<Product> products;

	public GetProductAmountCommand(List<Product> products) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Demo")));
		this.products = products;
	}

	@Override
	protected Float run() {
		float amount = 0f;
		for (Product orderProduct : products) {
			ProductStore product = new GetProductCommand(orderProduct.getProductId()).execute();
			amount += orderProduct.getQuantity() * product.getPrice();
		}
		return amount;
	}

	private static class GetProductCommand extends HystrixCommand<ProductStore> {

		final String productId;

		public GetProductCommand(String productId) {
			super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Demo")));
			this.productId = productId;
		}

		@Override
		protected ProductStore run() {
			return ProductService.findProduct(productId);
		}

		@Override
		protected String getCacheKey() {
			return productId;
		}
	}
}

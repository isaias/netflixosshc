package br.com.strategiatec.netflixosshc.hystrix;


import br.com.strategiatec.netflixosshc.domain.User;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class SuggestProductsCommand extends HystrixCommand<String> {

	private final User user;

	public SuggestProductsCommand(User user) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Demo")));
		this.user = user;
	}

	@Override
	protected String run() {
		// 10% will generate timeout, will call Fallback
		if (Math.random() > 0.9) {
			try {
				Thread.sleep(8000L);
			} catch (InterruptedException interruptedexception) {
				// do nothing
			}
		}
		// Get From HANA 80%
		if (Math.random() < 0.80) {
			return "Products offers gotten from SAP HANA";
		} else {
			return String.format(
					"Hi %s %s, thanks for buying at Super Store, an e-mail will be sent with exclusive offers!!!",
					user.getFirstName(), user.getLastName());
		}
	}

	@Override
	protected String getFallback() {
		return String.format(
				"Hi %s %s, thanks for buying at Super Store, an e-mail will be sent with exclusive offers!!! Fallback",
				user.getFirstName(), user.getLastName());
	}
}

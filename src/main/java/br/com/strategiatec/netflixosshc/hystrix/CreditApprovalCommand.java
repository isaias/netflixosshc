package br.com.strategiatec.netflixosshc.hystrix;

import java.util.UUID;

import br.com.strategiatec.netflixosshc.domain.CreditApprovalResult;
import br.com.strategiatec.netflixosshc.domain.User;
import br.com.strategiatec.netflixosshc.exceptions.ApprovalException;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CreditApprovalCommand extends HystrixCommand<CreditApprovalResult> {

	final User user;
	final float amount;

	public CreditApprovalCommand(User user, float amount) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Demo")));
		this.user = user;
		this.amount = amount;
	}

	@Override
	protected CreditApprovalResult run() {
		// Fail 2%
		if (Math.random() > 0.98) {
			throw new ApprovalException();
		}
		if (Math.random() > 0.95) {
			// random latency
			try {
				Thread.sleep((int) (Math.random() * 300) + 25);
			} catch (InterruptedException e) {
				// do nothing
			}
		}
		CreditApprovalResult result = new CreditApprovalResult(UUID.randomUUID().toString(), user.getCardNumber());
		return result;
	}
}

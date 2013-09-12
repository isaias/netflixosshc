package br.com.strategiatec.netflixosshc.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.strategiatec.netflixosshc.domain.CreditApprovalResult;
import br.com.strategiatec.netflixosshc.domain.Order;
import br.com.strategiatec.netflixosshc.domain.OrderConfirmationResult;
import br.com.strategiatec.netflixosshc.domain.User;
import br.com.strategiatec.netflixosshc.hystrix.CreditApprovalCommand;
import br.com.strategiatec.netflixosshc.hystrix.GetProductAmountCommand;
import br.com.strategiatec.netflixosshc.hystrix.GetUserInformationCommand;
import br.com.strategiatec.netflixosshc.hystrix.SuggestProductsCommand;

@Path("OrderConfirmation")
public class OrderConfirmationService {

	public OrderConfirmationService() {
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OrderConfirmationResult confirmOrder(Order order) {
		OrderConfirmationResult resultConfirmOrder = null;
		Future<User> user = new GetUserInformationCommand(order.getUserId()).queue();
		Future<Float> amount = new GetProductAmountCommand(order.getProducts()).queue();
		try {
			CreditApprovalResult result = new CreditApprovalCommand(user.get(), amount.get()).execute();
			if (result == null) {
				resultConfirmOrder = new OrderConfirmationResult("NOT_OK");
			} else {
				Future<String> suggestion = new SuggestProductsCommand(user.get()).queue();
				resultConfirmOrder = new OrderConfirmationResult("OK", result, suggestion.get(), amount.get());
			}
		} catch (InterruptedException e) {
			// do nothing
			e.printStackTrace();
		} catch (ExecutionException e) {
			// do nothing
			e.printStackTrace();
		}
		return resultConfirmOrder;
	}
}

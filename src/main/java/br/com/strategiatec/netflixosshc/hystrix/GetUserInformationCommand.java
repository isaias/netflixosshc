package br.com.strategiatec.netflixosshc.hystrix;

import java.util.HashMap;
import java.util.Map;

import br.com.strategiatec.netflixosshc.domain.User;
import br.com.strategiatec.netflixosshc.exceptions.UserNotFoundException;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class GetUserInformationCommand extends HystrixCommand<User> {

	private final String userId;
	static Map<String, User> mapUsers = new HashMap<String, User>();

	public GetUserInformationCommand(String userId) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("Demo")));
		mapUsers.put("K001", new User("K001", "1111222233334444", "Jhon", "Will"));
		mapUsers.put("U001", new User("U001", "4444222233334444", "Isaias", "Barroso"));
		mapUsers.put("B001", new User("B001", "6666222233334444", "Heberth", "Warley"));
		mapUsers.put("A001", new User("A001", "9999222233334444", "Jackson", "Duarte"));
		mapUsers.put("T001", new User("T001", "1111333366664444", "Will", "James"));
		this.userId = userId;
	}

	protected User run() throws Exception {
		if ("T001".equals(userId)) {
			Thread.sleep(8000L);
		}
		User user = mapUsers.get(userId);
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			return user;
		}
	}
}

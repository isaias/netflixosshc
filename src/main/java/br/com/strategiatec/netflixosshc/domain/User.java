package br.com.strategiatec.netflixosshc.domain;

public class User {

	private String username;
	private String cardNumber;
	private String firstName;
	private String lastName;

	public User(String username, String cardNumber, String firstName, String lastName) {
		this.username = username;
		this.cardNumber = cardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}

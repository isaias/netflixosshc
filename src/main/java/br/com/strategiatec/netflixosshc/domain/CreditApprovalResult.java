package br.com.strategiatec.netflixosshc.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CreditApprovalResult {

	private String codeAutorization;
	private String cardNumber;

	public CreditApprovalResult() {
	}

	public CreditApprovalResult(String codeAutorization, String cardNumber) {
		this.codeAutorization = codeAutorization;
		this.cardNumber = cardNumber;
	}

	public String getCodeAutorization() {
		return codeAutorization;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCodeAutorization(String codeAutorization) {
		this.codeAutorization = codeAutorization;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}

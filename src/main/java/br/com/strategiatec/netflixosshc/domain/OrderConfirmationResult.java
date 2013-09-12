package br.com.strategiatec.netflixosshc.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderConfirmationResult {

	private String resultCode;
	private CreditApprovalResult creditApprovalResult;
	private String suggestion;
	private float amount;

	public OrderConfirmationResult(String resultCode, CreditApprovalResult creditApprovalResult, String suggestion,
			Float amount) {
		this.resultCode = resultCode;
		this.creditApprovalResult = creditApprovalResult;
		this.suggestion = suggestion;
		this.amount = amount;
	}

	public OrderConfirmationResult(String resultCode) {
		this(resultCode, null, null, null);
	}

	public OrderConfirmationResult() {
	}

	public String getResultCode() {
		return resultCode;
	}

	public CreditApprovalResult getCreditApprovalResult() {
		return creditApprovalResult;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setCreditApprovalResult(CreditApprovalResult creditApprovalResult) {
		this.creditApprovalResult = creditApprovalResult;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}

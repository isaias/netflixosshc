package br.com.strategiatec.netflixosshc.exceptions;

public class ApprovalException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApprovalException() {
		super("Error on Approval Process");
	}
}

package com.skillstorm.project4.exceptions;

public class EmailExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2090995430402567208L;

	public EmailExistsException() {
		super();
	}
	
	public EmailExistsException(String email) {
		super(String.format("Email %s already in use.", email));
	}
}

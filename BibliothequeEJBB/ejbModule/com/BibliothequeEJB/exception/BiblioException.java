package com.BibliothequeEJB.exception;

public class BiblioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BiblioException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BiblioException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public BiblioException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BiblioException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BiblioException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Une erreur s'est produite";
	}
	
}

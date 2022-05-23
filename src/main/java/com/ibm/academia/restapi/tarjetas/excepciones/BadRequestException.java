package com.ibm.academia.restapi.tarjetas.excepciones;


public class BadRequestException extends RuntimeException {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8768336536375500640L;

	public BadRequestException(String mensaje) {
		super(mensaje);
	}

}

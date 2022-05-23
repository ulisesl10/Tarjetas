package com.ibm.academia.restapi.tarjetas.excepciones;

public class NotFoundException extends RuntimeException {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -131387444011353984L;

	public NotFoundException(String mensaje) {
		super(mensaje);
	}

}

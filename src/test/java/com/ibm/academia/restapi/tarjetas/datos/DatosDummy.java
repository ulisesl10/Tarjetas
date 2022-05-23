package com.ibm.academia.restapi.tarjetas.datos;

import java.math.BigDecimal;

import com.ibm.academia.restapi.tarjetas.enumeradores.TipoPasion;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Cliente;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Pasion;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;

public class DatosDummy {

	public static Cliente cliente01() {
		return new Cliente(null, "Ulises", "Lupercio", "522546217", 23, new BigDecimal(25000.00), "ulises");
	}
	
	public static Cliente cliente02() {
		return new Cliente(null, "Salvador", "Lupercio", "45353", 25, new BigDecimal(55000.00), "ulises");
	}
	
	public static Cliente cliente03() {
		return new Cliente(null, "Ulises", "Bocanegra", "312312", 18, new BigDecimal(15000.00), "ulises");
	}
	
	public static Tarjeta tarjeta01() {
		return new Tarjeta(null, "Platinum", "ulises");
	}
	
	public static Tarjeta tarjeta02() {
		return new Tarjeta(null, "Oro", "ulises");
	}
	
	public static Tarjeta tarjeta03() {
		return new Tarjeta(null, "B+Smart", "ulises");
	}
	
	public static Pasion pasion01() {
		return new Pasion(null, TipoPasion.SHOPPING, "ulises");
	}
	
	public static Pasion pasion02() {
		return new Pasion(null, TipoPasion.TRAVELS, "ulises");
	}
	
	public static Pasion pasion03() {
		return new Pasion(null, TipoPasion.BUSINESS, "ulises");
	}
}

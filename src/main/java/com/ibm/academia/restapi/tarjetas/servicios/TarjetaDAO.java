package com.ibm.academia.restapi.tarjetas.servicios;

import java.math.BigDecimal;
import java.util.Optional;

import com.ibm.academia.restapi.tarjetas.enumeradores.TipoPasion;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Tarjeta;

public interface TarjetaDAO {
	
	public Optional<Tarjeta> buscarPorId(Long id);

	public Tarjeta guardar(Tarjeta tarjeta);

	public Iterable<Tarjeta> buscarTodos();

	public void eliminarPorId(Long id);

	public Iterable<Tarjeta> guardarVarios(Iterable<Tarjeta> entities);
	
	public Iterable<Tarjeta> findTarjetasByClienteId(Long clienteId);

	public String obtenerTipoTarjeta(TipoPasion pasion, BigDecimal salario, Integer edad);
	
}

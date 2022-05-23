package com.ibm.academia.restapi.tarjetas.servicios;

import java.util.Optional;

import com.ibm.academia.restapi.tarjetas.modelo.entidades.Pasion;

public interface PasionDAO{
	
	public Optional<Pasion> buscarPorId(Long id);

	public Pasion guardar(Pasion passion);

	public Iterable<Pasion> buscarTodos();

	public void eliminarPorId(Long id);

	public Iterable<Pasion> guardarVarios(Iterable<Pasion> entities);

	public Iterable<Pasion> findPasionesByCliente(Long clienteId);
	
}

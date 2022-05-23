package com.ibm.academia.restapi.tarjetas.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.restapi.tarjetas.modelo.entidades.Pasion;

@Repository
public interface PasionRepository extends CrudRepository<Pasion, Long> {

	@Query("select p from Pasion p join fetch p.clientes c where c.id=?1")
	public Iterable<Pasion> findPasionesByCliente(Long clienteId);
}

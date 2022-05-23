package com.ibm.academia.restapi.tarjetas.repositorios;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.restapi.tarjetas.datos.DatosDummy;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Cliente;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Pasion;

@DataJpaTest
public class PasionRepositoryTest {
	
	@Autowired
	private PasionRepository pasionRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@BeforeEach
	void setUp() {
		pasionRepository.save(DatosDummy.pasion01());
		pasionRepository.save(DatosDummy.pasion02());
		pasionRepository.save(DatosDummy.pasion03());
	}

	@AfterEach
	void tearDown() {
		pasionRepository.deleteAll();
	}
	
	@Test
	@DisplayName("Test: Buscar Pasiones por el id del cliente")
	void findPasionesByCliente() {
		Optional<Pasion> pasion = pasionRepository.findById(2L);
		
		Cliente cliente01 = clienteRepository.save(DatosDummy.cliente01());

		Set<Pasion> pasiones = new HashSet<Pasion>();
		pasiones.add(pasion.get());
		
		cliente01.setPasiones(pasiones);
		
		Set<Cliente> clientesAsociados= new HashSet<Cliente>();
		clientesAsociados.add(cliente01);

		pasion.get().setClientes(clientesAsociados);
		
		clienteRepository.save(cliente01);
		pasionRepository.save(pasion.get());
		
		List<Pasion> expected = (List<Pasion>) pasionRepository.findPasionesByCliente(cliente01.getId());

		assertThat(expected.size() == 1).isTrue();
		
	}

}

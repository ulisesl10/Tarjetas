package com.ibm.academia.restapi.tarjetas.servicios;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ibm.academia.restapi.tarjetas.repositorios.PasionRepository;

@SpringBootTest
public class PasionDAOImplTest {
	
	@Autowired
	private PasionDAO passionDao;
	
	@MockBean
	private PasionRepository pasionRepository;
	
	@Test
	@DisplayName("Test: Buscar pasiones por id del cliente")
	void findPasionesByCliente() {

		passionDao.findPasionesByCliente(anyLong());
		
		verify(pasionRepository).findPasionesByCliente(anyLong());
	}

}

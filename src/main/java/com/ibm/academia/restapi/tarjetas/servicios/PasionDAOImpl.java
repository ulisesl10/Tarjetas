package com.ibm.academia.restapi.tarjetas.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.restapi.tarjetas.modelo.entidades.Pasion;
import com.ibm.academia.restapi.tarjetas.repositorios.PasionRepository;

@Service
public class PasionDAOImpl implements PasionDAO{
	private PasionRepository pasionRepository;

	@Autowired
	public PasionDAOImpl(PasionRepository pasionRepository) {
		this.pasionRepository = pasionRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Pasion> buscarPorId(Long id) {
		return pasionRepository.findById(id);
	}

	@Override
	@Transactional
	public Pasion guardar(Pasion pasion) {
		return pasionRepository.save(pasion);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pasion> buscarTodos() {
		return pasionRepository.findAll();
	}

	@Override
	@Transactional
	public void eliminarPorId(Long id) {
		pasionRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Iterable<Pasion> guardarVarios(Iterable<Pasion> pasiones) {
		return pasionRepository.saveAll(pasiones);
	}

	@Override
	public Iterable<Pasion> findPasionesByCliente(Long pasionId) {
		return pasionRepository.findPasionesByCliente(pasionId);
	}

}

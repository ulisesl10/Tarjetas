package com.ibm.academia.restapi.tarjetas.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.restapi.tarjetas.excepciones.NotFoundException;
import com.ibm.academia.restapi.tarjetas.modelo.entidades.Pasion;
import com.ibm.academia.restapi.tarjetas.servicios.PasionDAO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/restapi")
public class PasionController {
	@Autowired
	private PasionDAO pasionDao;


	@ApiOperation(value = "Consultar todas las pasiones")
	@ApiResponses({ @ApiResponse(code = 200, message = "Endpoint ejecutado satisfactoriamente"),
			@ApiResponse(code = 404, message = "No hay elementos en la bd") })
	@GetMapping("/pasiones/lista")
	public ResponseEntity<?> listarTodas() {
		List<Pasion> pasions = (List<Pasion>) pasionDao.buscarTodos();

		if (pasions.isEmpty())
			throw new NotFoundException("No existen pasiones en la base de datos");

		return new ResponseEntity<List<Pasion>>(pasions, HttpStatus.OK);
	}

	@GetMapping("/pasion/pasionId/{pasionId}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long pasionId) {
		Optional<Pasion> oPasion = pasionDao.buscarPorId(pasionId);

		if (!oPasion.isPresent())
			throw new NotFoundException(String.format("La Pasion con id: %d no existe", pasionId));

		return new ResponseEntity<Pasion>(oPasion.get(), HttpStatus.OK);
	}
	
	@PostMapping("/pasion")
	public ResponseEntity<?> guardar(@Valid @RequestBody Pasion pasion, BindingResult result) {

		Map<String, Object> validaciones = new HashMap<String, Object>();
		if (result.hasErrors()) {
			List<String> listaErrores = result.getFieldErrors().stream()
					.map(errores -> "Campo: " + errores.getField() + " " + errores.getDefaultMessage())
					.collect(Collectors.toList());
			validaciones.put("Lista errores", listaErrores);
			return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
		}

		Pasion pasionGuardada = pasionDao.guardar(pasion);
		return new ResponseEntity<Pasion>(pasionGuardada, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/pasion/eliminar/pasionId/{pasionId}")
	public ResponseEntity<?> eliminar(@PathVariable Long pasionId) {

		Optional<Pasion> oPasion = pasionDao.buscarPorId(pasionId);

		if (!oPasion.isPresent())
			throw new NotFoundException(String.format("La tarjeta con id: %d no existe", pasionId));

		pasionDao.eliminarPorId(pasionId);
		return new ResponseEntity<>("La pasion con id: " + pasionId + " fué eliminada", HttpStatus.NO_CONTENT);
	}

}

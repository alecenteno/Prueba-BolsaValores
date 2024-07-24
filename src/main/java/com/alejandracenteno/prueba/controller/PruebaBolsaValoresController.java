package com.alejandracenteno.prueba.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alejandracenteno.prueba.entity.County;
import com.alejandracenteno.prueba.entity.PlaceName;
import com.alejandracenteno.prueba.entity.Region;
import com.alejandracenteno.prueba.entity.State;
import com.alejandracenteno.prueba.service.CountyService;
import com.alejandracenteno.prueba.service.PlaceNameService;
import com.alejandracenteno.prueba.service.RegionService;
import com.alejandracenteno.prueba.service.StateService;

@RestController
@RequestMapping("/prueba/bolsa-valores")
public class PruebaBolsaValoresController {

	@Autowired
	private PlaceNameService pns;

	@Autowired
	private RegionService rs;

	@Autowired
	private StateService stateService;

	@Autowired
	private CountyService countyService;

	private static String MENSAJE = "Registro no encontrado";

	// Create a new place name
	@PostMapping("/placename")
	public ResponseEntity<?> create(@RequestBody PlaceName placeN) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pns.saveAll(placeN));
	}

	// Read a place name
	@GetMapping("/placename/busqueda/{name}")
	public ResponseEntity<?> readPN(@PathVariable(value = "name") String pnname) {
		Optional<PlaceName> opn = pns.findByName(pnname);

		if (!opn.isPresent()) {
			return ResponseEntity.ok(MENSAJE);
		}

		return ResponseEntity.ok(opn);
	}

	// Create a new region
	@PostMapping("/region")
	public ResponseEntity<?> createR(@RequestBody Region region) {
		return ResponseEntity.status(HttpStatus.CREATED).body(rs.saveAll(region));
	}

	// Read a region
	@GetMapping("/region/busqueda/{name}")
	public ResponseEntity<?> readR(@PathVariable(value = "name") String rname) {
		Optional<Region> or = rs.findByName(rname);

		if (!or.isPresent()) {

			return ResponseEntity.ok(MENSAJE);
		}

		return ResponseEntity.ok(or.get());
	}

	// Creando nuevo estado
	@PostMapping("/state")
	public ResponseEntity<?> createState(@RequestBody State state) {

		return ResponseEntity.status(HttpStatus.CREATED).body(stateService.saveAll(state));

	}

	// Read a region
	@GetMapping("/state/busqueda/{name}")
	public ResponseEntity<?> buscarEstado(@PathVariable(value = "name") String rname) {
		String name = rname.replace("_", " ");
		Optional<State> or = stateService.findByName(name);

		if (!or.isPresent()) {

			return ResponseEntity.ok(MENSAJE);
		}

		return ResponseEntity.ok(or.get());
	}

	// Creando nuevo condado
	@PostMapping("/county")
	public ResponseEntity<?> createCounty(@RequestBody County county) {

		return ResponseEntity.status(HttpStatus.CREATED).body(countyService.saveAll(county));

	}

	// 
	@GetMapping("/county/busqueda/{name}")
	public ResponseEntity<?> buscarCondado(@PathVariable(value = "name") String rname) {
		
		Optional<County> or = countyService.findByName(rname);

		if (!or.isPresent()) {

			return ResponseEntity.ok(MENSAJE);
		}

		return ResponseEntity.ok(or.get());
	}

}

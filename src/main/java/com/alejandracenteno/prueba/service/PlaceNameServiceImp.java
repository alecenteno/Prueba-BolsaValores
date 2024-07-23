package com.alejandracenteno.prueba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alejandracenteno.prueba.entity.PlaceName;
import com.alejandracenteno.prueba.repository.PlaceNameRepository;

@Service
public class PlaceNameServiceImp implements PlaceNameService{

	@Autowired
	private PlaceNameRepository placenamerepo;
	
	@Override
	@Transactional(readOnly =true)
	public Optional<PlaceName> findByName(String name) {
		return placenamerepo.findByName(name);
	}

	@Override
	@Transactional
	public PlaceName saveAll(PlaceName placename) {
		return placenamerepo.save(placename);
	}
	

}

package com.alejandracenteno.prueba.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alejandracenteno.prueba.entity.PlaceName;

@Service
public interface PlaceNameService {

	public Optional<PlaceName> findByName(String name);
	
	public PlaceName saveAll(PlaceName placename); 
	
}

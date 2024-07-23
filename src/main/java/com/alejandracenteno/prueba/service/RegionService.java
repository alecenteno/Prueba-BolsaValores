package com.alejandracenteno.prueba.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alejandracenteno.prueba.entity.Region;

@Service
public interface RegionService {

	public Optional<Region> findByName(String name);
	
	public Region saveAll(Region save);
}

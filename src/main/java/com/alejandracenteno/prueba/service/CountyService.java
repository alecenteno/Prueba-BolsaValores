package com.alejandracenteno.prueba.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alejandracenteno.prueba.entity.County;

@Service
public interface CountyService {
	
	public Optional<County> findByName(String name);

	public County saveAll(County save);
}

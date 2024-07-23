package com.alejandracenteno.prueba.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.alejandracenteno.prueba.entity.*;

@Service
public interface StateService {
	
	public Optional<State> findByName(String name);
	
	public State saveAll(State state);

}

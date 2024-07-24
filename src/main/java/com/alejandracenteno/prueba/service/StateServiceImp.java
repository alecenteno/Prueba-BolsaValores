package com.alejandracenteno.prueba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alejandracenteno.prueba.entity.State;
import com.alejandracenteno.prueba.repository.StateRepository;



@Service
public class StateServiceImp implements StateService{

	@Autowired
	private StateRepository stateRepo;
	
	@Override
	@Transactional(readOnly = true)
	public Optional<State> findByName(String name){
		return stateRepo.findByName(name);
	}

	@Override
	public State saveAll(State state) {
		return stateRepo.save(state);
	}
	
	
}

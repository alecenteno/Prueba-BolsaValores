package com.alejandracenteno.prueba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandracenteno.prueba.entity.County;
import com.alejandracenteno.prueba.repository.CountyRepository;


@Service
public class CountyServiceImp implements CountyService{

	@Autowired
	private CountyRepository countyRepo;
	

	@Override
	public Optional<County> findByName(String name) {
		return countyRepo.findByName(name);
	}

	@Override
	public County saveAll(County county) {
		return countyRepo.save(county);
	}
}

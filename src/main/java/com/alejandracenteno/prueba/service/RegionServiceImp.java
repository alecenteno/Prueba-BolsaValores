package com.alejandracenteno.prueba.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alejandracenteno.prueba.repository.RegionRepository;
import com.alejandracenteno.prueba.entity.Region;


@Service
public class RegionServiceImp implements RegionService{

	@Autowired
	private RegionRepository regionrepo;
	
	@Override
	@Transactional(readOnly = true)
	public Optional<Region> findByName(String name){
		return regionrepo.findByName(name);
	}
	
	@Override
	@Transactional
	public Region saveAll(Region region) {
		return regionrepo.save(region);
	}
}

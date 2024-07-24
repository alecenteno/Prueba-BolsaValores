package com.alejandracenteno.prueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alejandracenteno.prueba.entity.County;

public interface CountyRepository extends JpaRepository<County, Integer> {

	@Query(value= "SELECT * FROM county c WHERE c.name = :name", nativeQuery = true)
	Optional<County> findByName(String name);
}

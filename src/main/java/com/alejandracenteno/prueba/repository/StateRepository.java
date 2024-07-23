package com.alejandracenteno.prueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alejandracenteno.prueba.entity.State;

public interface StateRepository extends JpaRepository<State, Integer>{

	@Query(value="SELECT*FROM state s WHERE s.name= :name", nativeQuery = true)
	Optional<State> findByName(String name);
	
}

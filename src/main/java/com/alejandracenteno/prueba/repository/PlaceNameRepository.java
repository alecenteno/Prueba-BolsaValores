package com.alejandracenteno.prueba.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alejandracenteno.prueba.entity.PlaceName;


@Repository
public interface PlaceNameRepository extends JpaRepository<PlaceName, Integer>{

	@Query(value ="SELECT*FROM placename pn WHERE pn.name= :name", nativeQuery = true)
	Optional<PlaceName> findByName(String name);
		
	
}

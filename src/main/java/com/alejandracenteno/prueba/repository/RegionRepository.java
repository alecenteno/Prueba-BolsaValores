package com.alejandracenteno.prueba.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.alejandracenteno.prueba.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer>{

	@Query(value="SELECT*FROM region r WHERE r.name=:name", nativeQuery = true)
	Optional<Region> findByName(String name);
}

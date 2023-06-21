package com.backSpringBatch.postgres.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backSpringBatch.postgres.entity.PoliticasHorasSuple;

public interface PoliticasHorasSupleRepository extends JpaRepository<PoliticasHorasSuple, Long> {


	List<PoliticasHorasSuple> findByEstadoTrue();
	
	
}

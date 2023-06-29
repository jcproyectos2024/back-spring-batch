package com.backSpringBatch.postgres.repository;


import com.backSpringBatch.postgres.entity.HorasSuplementariasPersonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorasSuplementariasPersonalRepository extends JpaRepository <HorasSuplementariasPersonal, String> {

	HorasSuplementariasPersonal findByIdentificacionAndEstadoTrue(String identificacion);


	List<HorasSuplementariasPersonal> findAllByEstadoTrue();
}
